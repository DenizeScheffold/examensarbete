package se.denize.examensarbete.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import se.denize.examensarbete.model.Week;

import java.util.List;

@Service
public interface WeekService {

    ResponseEntity<Week> savePlan(Week week);
    ResponseEntity<Week> getPlanDays();
    ResponseEntity<Week> deleteByWeekId(long weekId);
}
