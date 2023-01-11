package se.denize.examensarbete.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.denize.examensarbete.model.Week;
import se.denize.examensarbete.model.Weekday;
import se.denize.examensarbete.repository.WeekRepository;

import java.util.List;
import java.util.Map;

@Service
public class WeekServiceImpl {

    private final WeekRepository weekRepository;

   // Week week = new Week();

    @Autowired
    public WeekServiceImpl(WeekRepository weekRepository) {
        this.weekRepository = weekRepository;
    }

/*
    public Map<Weekday, String> getPlanUserA(){
        return week.getPlanUserA();
    }

    public List<String> getPlanUserB(){
        return week.getPlanUserB();
    }



 */

    public void calculateConflict(List<String> getPlanUserB, List<String> getPlanUserA){


    }



}
