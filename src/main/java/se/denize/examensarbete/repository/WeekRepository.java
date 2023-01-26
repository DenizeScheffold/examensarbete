package se.denize.examensarbete.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import se.denize.examensarbete.model.Day;

import java.sql.Date;
import java.util.List;

@Repository
public interface WeekRepository extends JpaRepository<Day, Long> {


    @Query(value = "SELECT d FROM Day d WHERE d.weekNumber = ?1")
    List<Day> findByWeekNumber(int weekNumber);

    @Query(value = "SELECT d FROM Day d WHERE d.weekNumber = ?1 AND d.userId = ?2 ")
    List<Day> findByWeekNumberAndUser(int weekNumber, long userId);

    @Query(value = "SELECT d FROM Day d WHERE d.weekNumber = ?1 AND d.userId = ?2")
    List<Day> getWeekBeforeFromDB(int weekNumber, long userId);

    //@Query(value = "SELECT d FROM Day d WHERE d.weekNumber = ?1 AND d.date = ?2")
    //List<Day> getOneDay(int weekNumber, Date date);

    //@Query(value = "SELECT d FROM Day d WHERE d.date BETWEEN d.date LIKE ?1 AND d.date LIKE ?2")
    // @Query("select a from Article a where a.creationDateTime <= :creationDateTime")
    //    List<Article> findAllWithCreationDateTimeBefore(
    //      @Param("creationDateTime") Date creationDateTime);
    //List<Day> activitiesFromLast7days(String date7DaysBefore, String date);
}



/*
Date myDate1 = new SimpleDateFormat("yyyy-MM-dd").parse("2022-04-11");
Date myDate2 = new SimpleDateFormat("yyyy-MM-dd").parse("2022-05-11");

tutorials = tutorialRepository.findByDateBetween(myDate1, myDate2);
show(tutorials);


 */