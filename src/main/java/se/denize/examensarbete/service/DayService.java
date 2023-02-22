package se.denize.examensarbete.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import se.denize.examensarbete.model.Day;

import java.util.List;


public interface DayService {

    ResponseEntity<Day> savePlan(Day day);

    ResponseEntity<List<Day>> savePlans(List<Day> days);

    ResponseEntity<Day> getPlanDays();

    ResponseEntity<Day> deleteByDayId(long dayId);

    ResponseEntity<Day> editDay(Day day, long dayId);

    ResponseEntity<Day> getFullWeek(int weekNumber);

    ResponseEntity<List<Day>> getUser1FullWeek(int weekNumber, long userId);

    ResponseEntity<List<Day>> getUser2FullWeek(int weekNumber, long userId);

    List<Day> getWeekBeforeFromDB(int weekNumber, long userId);

    List<Day> getPlanFromUser(long userId);

    List<Day>findDaysWithoutResponse(long userId, int weekNumber);

    ResponseEntity<List<Day>> findDaysReadyForProcessPrimaryUser(long userId);

    ResponseEntity<List<Day>>findDaysReadyForProcessSecondaryUser(long userId);
}

