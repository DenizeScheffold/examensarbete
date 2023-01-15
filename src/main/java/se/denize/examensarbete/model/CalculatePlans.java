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
        List<String> savedDayPlans = new ArrayList<>();

        for (Day day : daysForUser1) {
            savedDayPlans.add(day.getPlanDay());
        }

        for(String savedDayUser1: savedDayPlans){
            System.out.println("saved days: " + savedDayUser1);
        }

        for (Day day : daysForUser2) {
            savedDayPlans.add(day.getPlanDay());
        }

        for(String savedDayUser2: savedDayPlans){
            System.out.println("saved days: " + savedDayUser2);
        }


/*
        System.out.println("inne i compare plans");
        //Loop through all days
        for (Day dayUser1 : daysForUser1) {
            for (Day dayUser2 : daysForUser2)
                //See if it is any conflict:
                if (daysForUser1. (daysForUser1.get(i))){
                System.out.println(i);
                // solveConflict(daysForUser1.get(i), daysForUser2.get(i));

                //No conflict - save to plan:
            } else{
                // saveToCommonPlan();
            }
        }


 */
    }
}