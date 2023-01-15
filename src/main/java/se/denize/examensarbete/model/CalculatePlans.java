package se.denize.examensarbete.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

//For local use only - not to store in db.
public class CalculatePlans {


    private List<Day> daysForUser1;
    private List<Day> daysForUser2;

    public CalculatePlans(List<Day> daysForUser1, List<Day> daysForUser2) {
        this.daysForUser1 = daysForUser1;
        this.daysForUser2 = daysForUser2;
    }

    public CalculatePlans() {
    }

    @ElementCollection
    public List<Day> getDaysForUser1() {
        return daysForUser1;
    }

    public void setDaysForUser1(List<Day> daysForUser1) {
        this.daysForUser1 = daysForUser1;
    }

    @ElementCollection
    public List<Day> getDaysForUser2() {
        return daysForUser2;
    }

    public void setDaysForUser2(List<Day> daysForUser2) {
        this.daysForUser2 = daysForUser2;
    }


    //TODO implement logic below, but not based on mock data
    //  MockDatabase db = new MockDatabase();


    public void comparePlans() {

        List<Day> daysForUser1 = getDaysForUser1();
        List<Day> daysForUser2 = getDaysForUser2();
        List<String> savedDayPlansUser1 = new ArrayList<>();
        List<String> savedDayPlansUser2 = new ArrayList<>();

        for (Day day : daysForUser1) {
            savedDayPlansUser1.add(day.getPlanDay());
        }

        for (String savedDayUser1 : savedDayPlansUser1) {
            System.out.println("saved days för user1: " + savedDayUser1);
        }

        for (Day day : daysForUser2) {
            savedDayPlansUser2.add(day.getPlanDay());
        }

        for (String savedDayUser2 : savedDayPlansUser2) {
            System.out.println("saved days for user2: " + savedDayUser2);
        }

//TODO: opitmize loop
        //Loop through all days
        for (int i = 0; i < savedDayPlansUser1.size(); i++) {
            for (int j = 0; j < savedDayPlansUser2.size(); j++) {
                if (savedDayPlansUser1.get(i).equals(savedDayPlansUser2.get(j))) {
                    System.out.println("one match: user1 " + savedDayPlansUser1.get(i) + " and User2 " + savedDayPlansUser1.get(i));
                    //solveConflict(daysForUser1.get(i), daysForUser2.get(i));

                }
            }
        }
/*
                //No conflict - save to plan:
            } else{
                // saveToCommonPlan();
            }
        }


 */
        /*
    }
    public void solveConflict(String userA, String userB) {
        //TODO get statistics from database/JSON from last 7 days.

      //  int countA = calculateUserAFromDb();
       // int countB = calculateUserBFromDb();
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



         */
    }
}