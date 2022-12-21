package se.denize.examensarbete.serviceImpl;

import org.springframework.stereotype.Service;
import se.denize.examensarbete.model.Week;
import se.denize.examensarbete.model.Weekday;

import java.util.List;
import java.util.Map;

@Service
public class WeekServiceImpl {

    Week week = new Week();

    public Map<Weekday, String> getPlanUserA(){
        return week.getPlanUserA();
    }

    public List<String> getPlanUserB(){
        return week.getPlanUserB();
    }


    public void calculateConflict(List<String> getPlanUserB, List<String> getPlanUserA){


    }


}
