package se.denize.examensarbete.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import se.denize.examensarbete.model.CalculatePlans;
import se.denize.examensarbete.model.Day;
import se.denize.examensarbete.repository.WeekRepository;
import se.denize.examensarbete.service.WeekService;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.text.ParseException;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

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
            weekRepository.save(new Day(day.getWeekNumber(), day.getUserId(), day.getDayDate(), day.getActivity(), day.getPossible()));
            return new ResponseEntity<>(day, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Day>> savePlans(List<Day> days) {

        for (Day day : days) {
            try {
                weekRepository.save(new Day(day.getWeekNumber(), day.getUserId(), day.getDayDate(), day.getActivity(), day.getPossible()));
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
    public ResponseEntity<Day> deleteByDayId(long dayId) {
        try {
            weekRepository.deleteById(dayId);
            return new ResponseEntity("Item deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Item not found: " + e, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Day> editDay(Day day, long dayId) {
        Day dayInDB = weekRepository.findById(dayId).get();

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

        return new ResponseEntity(weekRepository.save(dayInDB), HttpStatus.OK);
    }


    @Override
    public ResponseEntity<Day> getFullWeek(int weekNumber) {
        List<Day> userWeek = new ArrayList<>(weekRepository.findByWeekNumber(weekNumber));

        if (userWeek.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity(userWeek, HttpStatus.OK);
    }

    //TODO: start calculation when both weeks are submitted. Now user 1 has to submit before user2
    @Override
    public ResponseEntity<List<Day>> getUser1FullWeek(int weekNumber, long userId) {
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
    public ResponseEntity<List<Day>> getUser2FullWeek(int weekNumber, long userId) {
        List<Day> userWeek = new ArrayList<>(weekRepository.findByWeekNumberAndUser(weekNumber, userId));
        if (userWeek.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        calculatePlans.setDaysForUser2(userWeek);
        comparePlans(weekNumber);
        return new ResponseEntity<>(userWeek, HttpStatus.OK);
    }

    @Override
    public List<Day> getWeekBeforeFromDB(int weekNumber, long userId) {
        List<Day> userWeekDB = new ArrayList<>(weekRepository.findByWeekNumberAndUser(weekNumber, userId));
        return userWeekDB;
    }


    public void comparePlans(int weekNumber) {

        Iterator<Day> user1 = calculatePlans.getDaysForUser1().iterator();
        Iterator<Day> user2 = calculatePlans.getDaysForUser2().iterator();


        while (user1.hasNext()) {
            Day dayUser1 = user1.next();
            Day dayUser2 = user2.next();

            //check if there is conflicts. So if both has boolean Possible == true?
            if ((dayUser1.getPossible() && dayUser2.getPossible()
                    || (!dayUser1.getPossible() && !dayUser2.getPossible()))) {

                System.out.println("one match: user1 " + dayUser1.getPossible() + ", " + dayUser1.getDayDate() + " and user2: " + dayUser2.getPossible() + ", " + dayUser2.getDayDate());
                solveConflict(weekNumber, dayUser1, dayUser2);
            }


        }
    }


    //TODO: retrieve data from same week, days already set.
    public void solveConflict(int weekNumber, Day dayUser1, Day dayUser2) {
        int count1 = 0;
        int count2 = 0;


        //TODO: take data from last 7 days.

        Date dateUser1 = dayUser1.getDayDate();

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            cal.setTime(sdf.parse(dateUser1.toString()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        cal.add(Calendar.DAY_OF_MONTH, -7);
        String date7DaysBefore = sdf.format(cal.getTime());

        System.out.println(date7DaysBefore);

       // List<Day> activities    FromLast7days =



                // Predicate<String> d = day -> day.endsWith("GREEN");
                //  Predicate<String> i =  dayId -> dayId.endsWith("1");
                List < Day > user1WeekFromDB = weekRepository.getWeekBeforeFromDB(weekNumber - 1, 1);
        List<Day> user2WeekFromDB = weekRepository.getWeekBeforeFromDB(weekNumber - 1, 2);
        //String dayHL = Long.toString(dayUser1.getDayId());


        //TODO: see if user already has activity the same day  //get the activity from hämta, the same day
        /*
        Predicate<String> j =  dayId -> dayId.startsWith("1");
        if(i.test(dayHL)){
           String dayName = dayHL.substring(1,9);
           if(j.test(dayHL))
            dayUser1.setDayName(date);
           else{
               dayUser2.getDayName()
           }
        }
         */

/*
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
        }
        System.out.println("user 1 count: " + count1 + " user 2 count: " + count2);


        if (count1 >= count2) {
            System.out.println("User1 has the most number of activities : " + count1);
            dayUser1.setPlanDay("RED");
            dayUser2.setPlanDay("GREEN");
            // saveToCommonPlan();
        } else {
            System.out.println("User2 has the most number of activities : " + count2);
            dayUser2.setPlanDay("RED");
            dayUser1.setPlanDay("GREEN");
        }
        //TODO: take in the same week´s days that are already set.



 */
    }

}