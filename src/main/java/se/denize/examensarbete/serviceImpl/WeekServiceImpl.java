package se.denize.examensarbete.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import se.denize.examensarbete.model.User;
import se.denize.examensarbete.model.Day;
import se.denize.examensarbete.repository.UserRepository;
import se.denize.examensarbete.repository.WeekRepository;
import se.denize.examensarbete.service.WeekService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class WeekServiceImpl implements WeekService {

    private final WeekRepository weekRepository;
    private final UserRepository userRepository;

    @Autowired
    public WeekServiceImpl(WeekRepository weekRepository,
                           UserRepository userRepository) {
        this.weekRepository = weekRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<Day> savePlan(Day day) {
        try {
            weekRepository.save(new Day(day.getDayId(), day.getWeekNumber(), day.getUserPlanDay(), day.getUserId()));
            return new ResponseEntity<>(day, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Day> getPlanDays(){
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
    public ResponseEntity<User> editWeek(Day day, long weekId) {
        Day dayInDB = weekRepository.findById(weekId).get();

        if (Objects.nonNull(day.getUserId()))
           dayInDB.setUserId(day.getUserId());

        if(Objects.nonNull(day.getUserPlanDay()))
            dayInDB.setUserPlanDay(day.getUserPlanDay());

        if(Objects.nonNull(day.getWeekNumber()))
            dayInDB.setWeekNumber(day.getWeekNumber());

        if(Objects.nonNull(day.getDayId()))
            dayInDB.setDayId(day.getDayId());

        return new ResponseEntity(weekRepository.save(dayInDB), HttpStatus.OK);
    }



    /*
    //TODO implement logic below, but not based on mock data
    MockDatabase db = new MockDatabase();


    public void comparePlans(Week fullUserA, Week fullUserB) {

        List<String> userA = fullUserA.getUserPlan();
        List<String> userB = fullUserB.getUserPlan();
        //Loop through all days
        for (int i = 0; i < userA.size(); i++) {
            //See if it is any conflict:
            if (userA.get(i).equals(userB.get(i))) {
                solveConflict(userA.get(i), userB.get(i));

                //No conflict - save to plan:
            } else {
                saveToCommonPlan();
            }
        }
    }

    public void solveConflict(String userA, String userB) {
        //TODO get statistics from database/JSON from last 7 days.

        int countA = calculateUserAFromDb();
        int countB = calculateUserBFromDb();
        System.out.println(countA);
        System.out.println(countB);

        if (countA < countB) {
            System.out.println("UserA" + countA);
            // saveToCommonPlan();
        } else {
            System.out.println("UserB" + countB);
        }

        // saveToCommonPlan();
    }

    public void saveToCommonPlan() {

    }

    //TODO make a common calculator for all users
    public int calculateUserAFromDb() {

        Map<Weekday, String> userADb = db.userAdb().entrySet().stream()
                .filter(p -> p.getValue().startsWith("Y"))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return userADb.size();
    }

    public int calculateUserBFromDb() {

        Map<Weekday, String> userBDb = db.userBdb().entrySet().stream()
                .filter(p -> p.getValue().startsWith("Y"))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return userBDb.size();
    }

   */
}