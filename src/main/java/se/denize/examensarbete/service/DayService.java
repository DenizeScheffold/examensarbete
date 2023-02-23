package se.denize.examensarbete.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import se.denize.examensarbete.model.Day;

import java.util.List;


public interface DayService {

    ResponseEntity<Day> savePlan(Day day);

    ResponseEntity<List<Day>> savePlans(List<Day> days);

    ResponseEntity<Day> deleteByDayId(long dayId);

    ResponseEntity<Day> editDay(Day day, long dayId);



    List<Day>findDaysWithoutResponse(long userId, int weekNumber);

}
