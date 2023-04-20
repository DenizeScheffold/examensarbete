package se.denize.examensarbete.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import se.denize.examensarbete.model.CalculatePlans;
import se.denize.examensarbete.model.Day;
import se.denize.examensarbete.repository.DayRepository;
import se.denize.examensarbete.service.DayService;

import java.time.LocalDate;

import java.util.*;
import java.util.function.Predicate;

@Service
public class DayServiceImpl implements DayService {

    private final CalculatePlans calculatePlans;
    private final DayRepository dayRepository;

    @Autowired
    public DayServiceImpl(DayRepository dayRepository) {
        this.dayRepository = dayRepository;
        calculatePlans = new CalculatePlans();
    }

    @Override
    public ResponseEntity<List<Day>>findDaysWithoutResponse(long userId, int weekNumber){
        List<Day> daysWithoutResponse = dayRepository.findDaysWithoutResponse(userId, weekNumber);
        if (daysWithoutResponse.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(daysWithoutResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Day>>findDaysProcessed(long userId){
        List<Day> primaryUserDays = new ArrayList<>(dayRepository.findDaysProcessed(userId));
        if (primaryUserDays.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(primaryUserDays, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Day>> findDaysProcessedBothUserTrue(long userId, long otherParentId, int weekNumber){
        List<Day> bothParentsTrueDays = new ArrayList<>(dayRepository.findDaysProcessedBothUserTrue(userId, otherParentId, weekNumber));
        for(Day day: bothParentsTrueDays)
            System.out.println("list in findProcssedBothUserTrue: " + day.getDayDate() + " and userId: " + day.getUserId());
        if (bothParentsTrueDays.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(bothParentsTrueDays, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Day>>findDaysReadyForProcessBothUser(long userId, long otherParentId){
        List<Day> primaryUserDays = new ArrayList<>(dayRepository.findDaysReadyForProcessUser(userId));
        List<Day> secondaryUserDays = new ArrayList<>(dayRepository.findDaysReadyForProcessUser(otherParentId));
        calculatePlans.setDaysForUser1(primaryUserDays);
        calculatePlans.setDaysForUser2(secondaryUserDays);
        comparePlans();
        setBooleanTrueProcessed(primaryUserDays);
        setBooleanTrueProcessed(secondaryUserDays);

        if (primaryUserDays.isEmpty()&& secondaryUserDays.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity(primaryUserDays, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<Day> savePlan(Day day) {
        try {
            dayRepository.save(new Day(day.getWeekNumber(), day.getUserId(), day.getDayDate(), day.getActivity(), day.getPossible(), day.getProcessed()));
            return new ResponseEntity<>(day, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<Day>> savePlans(List<Day> days) {

        for (Day day : days) {
            try {
                dayRepository.save(new Day(day.getWeekNumber(), day.getUserId(), day.getDayDate(), day.getActivity(), day.getPossible(), day.getProcessed()));
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }
        return new ResponseEntity<>(days, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Day> deleteByDayId(long dayId) {
        try {
            dayRepository.deleteById(dayId);
            return new ResponseEntity("Item deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Item not found: " + e, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Day> editDay(Day day, long dayId) {
        Day dayInDB = dayRepository.findDayById(dayId);

        if (Objects.nonNull(day.getUserId()))
            dayInDB.setUserId(day.getUserId());

        if (Objects.nonNull(day.getWeekNumber()))
            dayInDB.setWeekNumber(day.getWeekNumber());

        if (Objects.nonNull(day.getDayDate()))
            dayInDB.setDayDate(day.getDayDate());

        if (Objects.nonNull(day.getActivity()))
            dayInDB.setActivity(day.getActivity());

        if (Objects.nonNull(day.getPossible()))
            dayInDB.setPossible(day.getPossible());

        if (Objects.nonNull(day.getProcessed()))
            dayInDB.setProcessed(day.getProcessed());

        return new ResponseEntity<>(dayRepository.save(dayInDB), HttpStatus.OK);
    }


    public void comparePlans() {

        Iterator<Day> user1 = calculatePlans.getDaysForUser1().iterator();
        Iterator<Day> user2 = calculatePlans.getDaysForUser2().iterator();


        while (user1.hasNext()) {
            Day dayUser1 = user1.next();
            Day dayUser2 = user2.next();



            //check if there is conflicts. So if both has boolean Possible == true?
            if ((dayUser1.getPossible() && dayUser2.getPossible()
                    || (!dayUser1.getPossible() && !dayUser2.getPossible()))) {

                System.out.println("one match: user1 " + dayUser1.getPossible() + ", " + dayUser1.getDayDate() + " and user2: " + dayUser2.getPossible() + ", " + dayUser2.getDayDate());
                solveConflict(dayUser1, dayUser2);
            }


        }
    }


    public void solveConflict(Day dayUser1, Day dayUser2) {
        Random random = new Random();
        long parent1 = dayUser1.getUserId();

        int count1 = 0;
        int count2 = 0;

        List<Day> activitiesFromLast7days = getLast7Days(dayUser1);

        Predicate<Long> d = userId -> userId == parent1;
        Iterator<Day> days = activitiesFromLast7days.iterator();

        while (days.hasNext()) {
            Day dayDB = days.next();
        //    System.out.println("in activites from last 7 days " + dayDB);

            //IF possible (-> did an activity) set to true
            if (dayDB.getPossible()) {
                //IF user is user1
                if (d.test(dayDB.getUserId())) {
                    count1++;
                }
                //IF user is NOT user1
                if (!(d.test(dayDB.getUserId()))) {
                    count2++;
                }
            }

        }
        System.out.println("user 1 count: " + count1 + " user 2 count: " + count2);

        if (count1 < count2) {
            System.out.println("User2 has more activities. Set false on Possible");
            dayUser1.setPossible(true);
            dayUser2.setPossible(false);
            dayUser1.setProcessed(true);
            dayUser2.setProcessed(true);
        } else if (count1 > count2) {
            System.out.println("User1 has more activities. Set false on Possible");
            dayUser2.setPossible(true);
            dayUser1.setPossible(false);
            dayUser1.setProcessed(true);
            dayUser2.setProcessed(true);
        } else {
            int randomUser = random.nextInt(2);
            if(randomUser==0){
                System.out.println("Same number of activities. User 2 randomly selected. Set false on Possible");
                dayUser2.setPossible(false);
                dayUser1.setPossible(true);
                dayUser1.setProcessed(true);
                dayUser2.setProcessed(true);
            } else {
                System.out.println("Same number of activities. User 1 randomly selected. Set false on Possible");
                dayUser1.setPossible(false);
                dayUser2.setPossible(true);
                dayUser1.setProcessed(true);
                dayUser2.setProcessed(true);

            }
        }

        editDay(dayUser1, dayUser1.getDayId());
        editDay(dayUser2, dayUser2.getDayId());
    }

    public List<Day> getLast7Days(Day dayUser1) {

        LocalDate dateUser1 = dayUser1.getDayDate();

        LocalDate date7DaysBefore = dateUser1.minusDays(7);

        System.out.println(date7DaysBefore);

        List<Day> activitiesFromLast7days = dayRepository.activitiesFromLast7days(
                date7DaysBefore, dateUser1);

        return activitiesFromLast7days;
    }

    public void setBooleanTrueProcessed(List<Day> dayUser){
        //Sets days to processed, hence they will be displayed as the set plan in FE.
        for(Day day: dayUser){
            day.setProcessed(true);
            editDay(day,day.getDayId());
        }

    }
}