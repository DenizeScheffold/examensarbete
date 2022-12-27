package se.denize.examensarbete.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.denize.examensarbete.model.User;
import se.denize.examensarbete.model.Week;
import se.denize.examensarbete.model.Weekday;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
