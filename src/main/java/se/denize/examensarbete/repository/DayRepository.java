package se.denize.examensarbete.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import se.denize.examensarbete.model.Day;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DayRepository extends JpaRepository<Day, Long> {

    @Query(value="SELECT d FROM Day d WHERE d.dayId= ?1")
    Day findDayById(long dayId);

    @Query(value = "SELECT d from Day d where d.processed=true AND d.dayDate BETWEEN :startDate AND :endDate")
    List<Day> activitiesFromLast7days(@Param("startDate") LocalDate date7DaysBefore, @Param("endDate") LocalDate date);

    @Query(value="SELECT d FROM Day d WHERE d.possible IS NULL AND d.userId =?1 AND d.weekNumber=?2")
    List<Day>findDaysWithoutResponse(long userId, int weekNumber);

    @Query(value="SELECT d FROM Day d WHERE (d.processed = false OR d.processed IS NULL) AND d.possible IS NOT NULL AND d.userId =?1")
    List<Day>findDaysReadyForProcessUser(long userId);

    @Query(value="SELECT d FROM Day d WHERE d.processed=true AND d.userId=?1")
    List<Day>findDaysProcessed(long userId);

    @Query(value="SELECT d FROM Day d WHERE d.processed=true AND d.possible=true AND (d.userId=?1 OR d.userId=?2) AND d.weekNumber=?3 ORDER BY DATE(d.dayDate) ASC")
    List<Day>findDaysProcessedBothUserTrue(long userId, long otherParentId, int weekNumber);

    //TODO: have empty days in db to retrieve to frontend and patch from there.
}

