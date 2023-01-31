package se.denize.examensarbete.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import se.denize.examensarbete.model.Day;

import java.util.Date;
import java.util.List;

@Repository
public interface DayRepository extends JpaRepository<Day, Long> {


    @Query(value = "SELECT d FROM Day d WHERE d.weekNumber = ?1")
    List<Day> findByWeekNumber(int weekNumber);

    @Query(value = "SELECT d FROM Day d WHERE d.weekNumber = ?1 AND d.userId = ?2 ")
    List<Day> findByWeekNumberAndUser(int weekNumber, long userId);

    @Query(value = "SELECT d from Day d where d.dayDate BETWEEN :startDate AND :endDate")
    List<Day> activitiesFromLast7days(@Param("startDate") Date date7DaysBefore, @Param("endDate") Date date);
}
