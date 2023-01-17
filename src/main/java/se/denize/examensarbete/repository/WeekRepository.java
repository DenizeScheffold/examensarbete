package se.denize.examensarbete.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import se.denize.examensarbete.model.Day;

import java.util.List;

@Repository
public interface WeekRepository extends JpaRepository<Day, Long> {

    @Query(value = "SELECT d FROM Day d WHERE d.weekNumber = ?1")
    List<Day> findByWeekNumber(long weekNumber);

    @Query(value = "SELECT d FROM Day d WHERE d.weekNumber = ?1 AND d.userId = ?2 ")
    List<Day> findByWeekNumberAndUser(long weekNumber, long userId);

    @Query(value = "SELECT d FROM Day d WHERE d.weekNumber = ?1 AND d.userId = ?2")
    List<Day> getWeekBeforeFromDB(long weekNumber, long userId);

    @Query(value = "SELECT d FROM Day d WHERE d.weekNumber = ?1 AND d.dayName = ?2")
    List<Day> getSameDay(long weekNumber, String dayName);
}



/*
Date myDate1 = new SimpleDateFormat("yyyy-MM-dd").parse("2022-04-11");
Date myDate2 = new SimpleDateFormat("yyyy-MM-dd").parse("2022-05-11");

tutorials = tutorialRepository.findByDateBetween(myDate1, myDate2);
show(tutorials);


 */