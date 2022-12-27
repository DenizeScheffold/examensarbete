package se.denize.examensarbete.service;

import org.springframework.stereotype.Service;

import java.util.List;


//Contains ALL logic for the plan. Fetch data from database.
@Service
public class WeekService {



    public void comparePlans(List<String> userA, List<String> userB){

        //Loop through all days
        for(int i=0; i<12; i++) {
            //See if it is any conflict:
            if (userA.get(0) == userB.get(0)) {
                //See if conflict is RED-RED
                if (userA.get(0).equals("MONDAY-RED")) {
                    solveRedRed();
                }
                //See if conflict is GREEN-GREEN
                if (userA.get(0).equals("MONDAY-GREEN")) {
                    solveGreenGreen();
                }
                //No conflict - save to plan:
            } else {
                //TODO save to plan
            }
        }
    }

    public void solveGreenGreen(){
        //TODO get statistics from database/JSON.
    }

    public void solveRedRed(){
        //TODO get statistics from database/JSON.
    }

}
