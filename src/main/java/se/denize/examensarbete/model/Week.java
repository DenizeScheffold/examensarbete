package se.denize.examensarbete.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


//TODO: ändra tabellnamn till days och även weekid till dayid
@Entity
@Getter
@Setter
@Table(name = "weeks")
public class Week {


    //TODO: make weekId calculate from userId + date + 1 for hämta/2 for lämna Ex: 12301091
    @Id
    @Column(name = "week_id", nullable = false)
    private Long weekId;

    @Column (name = "userPlanDay" )
    private String userPlanDay;

    @Column (name = "weekNumber")
    private Long weekNumber;

    @Column(name="user_id")
    private Long userId;

    public Week(Long weekId, Long weekNumber, String userPlanDay, Long userId) {
        this.weekId = weekId;
        this.weekNumber = weekNumber;
        this.userPlanDay = userPlanDay;
        this.userId = userId;
    }

    public Week() {
    }


    public Long getWeekId() {
        return weekId;
    }

    public void setWeekId(Long weekId) {
        this.weekId = weekId;
    }

    public Long getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(Long weekNumber) {
        this.weekNumber = weekNumber;
    }

    public String getUserPlanDay() {
        return userPlanDay;
    }

    public void setUserPlanDay(String userPlanDay) {
        this.userPlanDay = userPlanDay;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


}