package se.denize.examensarbete.service;

import org.springframework.stereotype.Service;
import se.denize.examensarbete.model.User;
import se.denize.examensarbete.model.Weekday;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


//Contains ALL logic for the plan. Fetch data from database.
@Service
public class WeekService {

    MockDatabase db = new MockDatabase();

    public void comparePlans(User fullUserA, User fullUserB) {

        List<String> userA = fullUserA.getPlanUser();
        List<String> userB = fullUserB.getPlanUser();
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
    public int calculateUserAFromDb(){

        Map<Weekday, String> userADb = db.userAdb().entrySet().stream()
                .filter(p -> p.getValue().startsWith("Y"))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

       return userADb.size();
    }

    public int calculateUserBFromDb(){

        Map<Weekday, String> userBDb = db.userBdb().entrySet().stream()
                .filter(p -> p.getValue().startsWith("Y"))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

       return userBDb.size();
    }
}
