package se.denize.examensarbete.repository;

import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import se.denize.examensarbete.model.Day;
import se.denize.examensarbete.model.User;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface DayRepository extends JpaRepository<Day, Long> {

    @Query(value="SELECT d FROM Day d WHERE d.dayId= ?1")
    Day findDayById(long dayId);

    @Query(value = "SELECT d FROM Day d WHERE d.weekNumber = ?1")
    List<Day> findByWeekNumber(int weekNumber);

    @Query(value = "SELECT d FROM Day d WHERE d.weekNumber = ?1 AND d.userId = ?2 ")
    List<Day> findByWeekNumberAndUser(int weekNumber, long userId);

    @Query(value = "SELECT d from Day d where d.processed=true AND d.dayDate BETWEEN :startDate AND :endDate")
    List<Day> activitiesFromLast7days(@Param("startDate") LocalDate date7DaysBefore, @Param("endDate") LocalDate date);

    @Query(value="SELECT d FROM Day d WHERE d.possible IS NULL AND d.userId =?1 AND d.weekNumber=?2")
    List<Day>findDaysWithoutResponse(long userId, int weekNumber);


    @Query(value="SELECT d FROM Day d WHERE (d.processed = false OR d.processed IS NULL) AND d.possible IS NOT NULL AND d.userId =?1")
    List<Day>findDaysReadyForProcessUser(long userId);

    @Query(value="SELECT d FROM Day d WHERE d.processed=true AND d.userId=?1")
    List<Day>findDaysProcessed(long userId);

    @Query(value="SELECT d FROM Day d WHERE d.processed=true AND d.possible=true AND d.weekNumber=?3 AND (d.userId=?1 OR d.userId=?2)")
    List<Day>findDaysProcessedBothUserTrue(long userId, long otherParentId, int weekNumber);


    //TODO: have empty days in db to retrieve to FE and patch from there.
}

