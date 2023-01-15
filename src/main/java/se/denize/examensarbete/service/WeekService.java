package se.denize.examensarbete.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import se.denize.examensarbete.model.Day;

import java.util.List;

@Service
public interface WeekService {

    ResponseEntity<Day> savePlan(Day day);
    public ResponseEntity<List<Day>> savePlans(List<Day> days);
    ResponseEntity<Day> getPlanDays();
    ResponseEntity<Day> deleteByWeekId(long weekId);
    ResponseEntity<Day> editWeek(Day day, long weekId);
    ResponseEntity<Day> getFullWeek(long weekNumber);

    ResponseEntity<List<Day>> getUser1FullWeek(long weekNumber, long userId);
    ResponseEntity<List<Day>> getUser2FullWeek(long weekNumber, long userId);


}
