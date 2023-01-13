package se.denize.examensarbete.model;

import jakarta.persistence.*;


//TODO: ändra tabellnamn till days och även weekid till dayid
@Entity
@Table(name = "weeks")
public class Day {


    //TODO: make weekId calculate from userId + date + 1 for hämta/2 for lämna Ex: 12301091
    @Id
    @Column(name = "week_id", nullable = false)
    private Long dayId;

    @Column (name = "userPlanDay" )
    private String userPlanDay;

    @Column (name = "weekNumber")
    private Long weekNumber;

    @Column(name="user_id")
    private Long userId;

    public Day(Long dayId, Long weekNumber, String userPlanDay, Long userId) {
        this.dayId = dayId;
        this.weekNumber = weekNumber;
        this.userPlanDay = userPlanDay;
        this.userId = userId;
    }

    public Day() {
    }

    public Long getDayId() {
        return dayId;
    }

    public void setDayId(Long dayId) {
        this.dayId = dayId;
    }

    public String getUserPlanDay() {
        return userPlanDay;
    }

    public void setUserPlanDay(String userPlanDay) {
        this.userPlanDay = userPlanDay;
    }

    public Long getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(Long weekNumber) {
        this.weekNumber = weekNumber;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}