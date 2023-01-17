package se.denize.examensarbete.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import se.denize.examensarbete.model.CalculatePlans;
import se.denize.examensarbete.model.Day;
import se.denize.examensarbete.repository.WeekRepository;
import se.denize.examensarbete.service.WeekService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

@Service
public class WeekServiceImpl implements WeekService {


    //TODO: see if this is convention?
    private final CalculatePlans calculatePlans;
    private final WeekRepository weekRepository;

    @Autowired
    public WeekServiceImpl(WeekRepository weekRepository) {
        this.weekRepository = weekRepository;
        calculatePlans = new CalculatePlans();
    }

    @Override
    public ResponseEntity<Day> savePlan(Day day) {
        try {
            weekRepository.save(new Day(day.getDayId(), day.getWeekNumber(), day.getPlanDay(), day.getUserId()));
            return new ResponseEntity<>(day, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Day>> savePlans(List<Day> days) {

        for (Day day : days) {
            try {
                weekRepository.save(new Day(day.getDayId(), day.getWeekNumber(), day.getPlanDay(), day.getUserId()));
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }
        return new ResponseEntity<>(days, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Day> getPlanDays() {
        List<Day> userPlanDays = new ArrayList<>(weekRepository.findAll());

        if (userPlanDays.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity(userPlanDays, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Day> deleteByWeekId(long weekId) {
        try {
            weekRepository.deleteById(weekId);
            return new ResponseEntity("Item deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Item not found: " + e, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Day> editWeek(Day day, long weekId) {
        Day dayInDB = weekRepository.findById(weekId).get();

        if (Objects.nonNull(day.getUserId()))
            dayInDB.setUserId(day.getUserId());

        if (Objects.nonNull(day.getPlanDay()))
            dayInDB.setPlanDay(day.getPlanDay());

        if (Objects.nonNull(day.getWeekNumber()))
            dayInDB.setWeekNumber(day.getWeekNumber());

        if (Objects.nonNull(day.getDayId()))
            dayInDB.setDayId(day.getDayId());

        return new ResponseEntity(weekRepository.save(dayInDB), HttpStatus.OK);
    }


    @Override
    public ResponseEntity<Day> getFullWeek(long weekNumber) {
        List<Day> userWeek = new ArrayList<>(weekRepository.findByWeekNumber(weekNumber));

        if (userWeek.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity(userWeek, HttpStatus.OK);
    }

    //TODO: start calculation when both weeks are submitted. Now user 1 has to submit before user2
    @Override
    public ResponseEntity<List<Day>> getUser1FullWeek(long weekNumber, long userId) {
        List<Day> userWeek = new ArrayList<>(weekRepository.findByWeekNumberAndUser(weekNumber, userId));

        if (userWeek.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        try {
            calculatePlans.setDaysForUser1(userWeek);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userWeek, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Day>> getUser2FullWeek(long weekNumber, long userId) {
        List<Day> userWeek = new ArrayList<>(weekRepository.findByWeekNumberAndUser(weekNumber, userId));
        if (userWeek.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        calculatePlans.setDaysForUser2(userWeek);
        comparePlans(weekNumber);
        return new ResponseEntity<>(userWeek, HttpStatus.OK);
    }

    @Override
    public List<Day> getWeekBeforeFromDB(long weekNumber, long userId) {
        List<Day> userWeekDB = new ArrayList<>(weekRepository.findByWeekNumberAndUser(weekNumber, userId));
        return userWeekDB;
    }


    public void comparePlans(long weekNumber) {

        Iterator<Day> user1 = calculatePlans.getDaysForUser1().iterator();
        Iterator<Day> user2 = calculatePlans.getDaysForUser2().iterator();

        while (user1.hasNext()) {
            Day dayUser1 = user1.next();
            Day dayUser2 = user2.next();
            if (dayUser1.getPlanDay().equals(dayUser2.getPlanDay())) {
                System.out.println("one match: user1 " + dayUser1.getPlanDay() + " and user2: " + dayUser2.getPlanDay());
                solveConflict(weekNumber, dayUser1, dayUser2);
            }
        }

    }


    //TODO: retrieve data from same week, days already set.
    public void solveConflict(long weekNumber, Day dayUser1, Day dayUser2) {
        int count1 = 0;
        int count2 = 0;

        Predicate<String> d = day -> day.endsWith("GREEN");
        Predicate<String> i =  dayId -> dayId.endsWith("1");
      //  Predicate<String> k =  dayPlan -> dayPlan.startsWith("");
        Predicate<String> j =  dayId -> dayId.startsWith("1");
        List<Day> user1WeekFromDB = weekRepository.getWeekBeforeFromDB(weekNumber - 1, 1);
        List<Day> user2WeekFromDB = weekRepository.getWeekBeforeFromDB(weekNumber - 1, 2);
        String dayHL = Long.toString(dayUser1.getDayId());

        if(i.test(dayHL)){
            //TODO: see if user already has activity the same day  //get the activity from hämta, the same day
         /*
           String dayName = dayHL.substring(1,9);

           if(j.test(dayHL))
            dayUser1.setDayName(date);
           else{
               dayUser2.getDayName()
           }

          */
        }

        Iterator<Day> user1 = user1WeekFromDB.iterator();
        Iterator<Day> user2 = user2WeekFromDB.iterator();

        //calculate number of GREEN activities.
        while (user1.hasNext()) {
            Day dayUser1DB = user1.next();
            Day dayUser2DB = user2.next();

            if (d.test(dayUser1DB.getPlanDay()))
                count1++;

            if (d.test(dayUser2DB.getPlanDay()))
                count2++;

            System.out.println("user 1 count: " + count1 + " user 2 count: " + count2);
        }

        if (count1 >= count2) {
            System.out.println("User1 has the most number of activities : " + count1);
            dayUser1.setPlanDay("RED");
            dayUser2.setPlanDay("GREEN");
            // saveToCommonPlan();
        } if (count1 < count2) {
            System.out.println("User2 has the most number of activities : " + count2);
            dayUser2.setPlanDay("RED");
            dayUser1.setPlanDay("GREEN");
        } else{
            System.out.println("no result");
        }
        //TODO: take in the same week´s days that are already set.

    }

}