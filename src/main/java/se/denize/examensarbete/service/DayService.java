package se.denize.examensarbete.service;

import org.springframework.http.ResponseEntity;
import se.denize.examensarbete.model.Day;

import java.util.List;


public interface DayService {

    ResponseEntity<Day> savePlan(Day day);

    ResponseEntity<List<Day>> savePlans(List<Day> days);

    ResponseEntity<Day> deleteByDayId(long dayId);

    ResponseEntity<Day> editDay(Day day, long dayId);

    ResponseEntity<List<Day>>findDaysReadyForProcessBothUser(long userId, long otherParentId);

    ResponseEntity<List<Day>>findDaysWithoutResponse(long userId, int weekNumber);

}
