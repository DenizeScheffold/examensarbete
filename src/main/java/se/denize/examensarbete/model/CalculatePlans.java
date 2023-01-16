package se.denize.examensarbete.model;

import jakarta.persistence.ElementCollection;
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


    //TODO implement logic below, but not based on mock data
    //  MockDatabase db = new MockDatabase();


    public void comparePlans() {

        Iterator<Day> day1 = daysForUser1.iterator();
        Iterator<Day> day2 = daysForUser2.iterator();

        while(day1.hasNext()){
            Day dayUser1 = day1.next();
            Day dayUser2 = day2.next();
          if(dayUser1.getPlanDay().equals(dayUser2.getPlanDay())){
              System.out.println("one match: user1 " + dayUser1.getPlanDay() + " and user2: " + dayUser2.getPlanDay());
            }
        }


         /*

        java.util.function.BiPredicate<String, String> isSame = String::equals;

       Stream<String> day1 = daysForUser1.stream().map(Day::getPlanDay);
        System.out.println(day1);

       while(daysForUser1.iterator().hasNext()) {
           if (isSame.test(daysForUser1.iterator().next().getPlanDay(),daysForUser2.iterator().next().getPlanDay())) {
               System.out.println("is same: " + daysForUser1.iterator().next().getPlanDay() + " and " + daysForUser2.iterator().next().getPlanDay());
           }
       }

            System.out.println("one match: user1 " + daysForUser1.iterator().next().getPlanDay() + " and user2: "
                    + daysForUser2.iterator().next().getPlanDay());
        }


        for (Day day1 : daysForUser1)

            for (Day day2 : daysForUser2)
                if (day1.getPlanDay().equals(day2.getPlanDay())) {
                    System.out.println("one match: user1 " + day1.getPlanDay() + " and user2: " + day2.getPlanDay());}

    }
 /*
        for (String savedDayUser1 : savedDayPlansUser1) {
            System.out.println("saved days för user1: " + savedDayUser1);
        }


        for (String savedDayUser2 : savedDayPlansUser2) {
            System.out.println("saved days for user2: " + savedDayUser2);
        }

//TODO: opitmize loop
        //Loop through all days

        for (int i = 1; i < 40; i +=4) {

            // for (int j = 0; j < savedDayPlansUser1.size(); j += 3) {
            if (daysForUser1.get(i).equals(daysForUser2.get(i))) {
                System.out.println("one match: user1 " + daysForUser2.get(i) + " and User2 "
                        + daysForUser2.get(i));
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
