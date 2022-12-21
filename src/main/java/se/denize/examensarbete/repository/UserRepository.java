package se.denize.examensarbete.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.denize.examensarbete.model.User;
import se.denize.examensarbete.model.Week;
import se.denize.examensarbete.model.Weekday;

public interface UserRepository  extends JpaRepository<User, Long> {
}
