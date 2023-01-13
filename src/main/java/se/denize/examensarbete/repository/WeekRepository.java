package se.denize.examensarbete.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.denize.examensarbete.model.Day;

@Repository
public interface WeekRepository extends JpaRepository<Day, Long> {
}
