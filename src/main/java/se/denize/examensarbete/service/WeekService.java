package se.denize.examensarbete.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import se.denize.examensarbete.model.User;
import se.denize.examensarbete.model.Day;

@Service
public interface WeekService {

    ResponseEntity<Day> savePlan(Day day);
    ResponseEntity<Day> getPlanDays();
    ResponseEntity<Day> deleteByWeekId(long weekId);
    ResponseEntity<Day> editWeek(Day day, long weekId);
    ResponseEntity<Day> getFullWeek(long weekNumber);
}
