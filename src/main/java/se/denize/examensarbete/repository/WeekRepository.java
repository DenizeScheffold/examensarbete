package se.denize.examensarbete.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.denize.examensarbete.model.Week;
import se.denize.examensarbete.model.Weekday;

public interface WeekRepository extends JpaRepository<Week, Long> {
}
