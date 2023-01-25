package se.denize.examensarbete.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import se.denize.examensarbete.model.Day;

import java.util.List;

@Service
public interface WeekService {

    ResponseEntity<Day> savePlan(Day day);
     ResponseEntity<List<Day>> savePlans(List<Day> days);
    ResponseEntity<Day> getPlanDays();
    /*
    ResponseEntity<Day> deleteByWeekId(int weekId);
    ResponseEntity<Day> editWeek(Day day, int weekId);
    ResponseEntity<Day> getFullWeek(long weekNumber);

    ResponseEntity<List<Day>> getUser1FullWeek(int weekNumber, long userId);
    ResponseEntity<List<Day>> getUser2FullWeek(int weekNumber, long userId);

    List<Day> getWeekBeforeFromDB(int weekNumber, long userId);


     */
}
