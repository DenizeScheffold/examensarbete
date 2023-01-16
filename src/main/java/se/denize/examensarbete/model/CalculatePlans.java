package se.denize.examensarbete.model;

import jakarta.persistence.ElementCollection;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Iterator;
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

/*

    public void comparePlans(long weekNumber) {

        Iterator<Day> user1 = daysForUser1.iterator();
        Iterator<Day> user2 = daysForUser2.iterator();

        while (user1.hasNext()) {
            Day dayUser1 = user1.next();
            Day dayUser2 = user2.next();
            if (dayUser1.getPlanDay().equals(dayUser2.getPlanDay())) {
                System.out.println("one match: user1 " + dayUser1.getPlanDay() + " and user2: " + dayUser2.getPlanDay());
                solveConflict(weekNumber, dayUser1, dayUser2);
            }
        }

    }

       public void solveConflict(long weekNumber, Day dayUser1, Day dayUser2){
        long weekToRetrieve = weekNumber-1;

       }



                //No conflict - save to plan:
            } else{
                // saveToCommonPlan();
            }
        }


 */
        /*
    }
    public void solveConflict(List<Day> daysForUser1, List<Day> daysForUser2) {
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
