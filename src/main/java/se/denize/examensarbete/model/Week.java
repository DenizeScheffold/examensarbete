package se.denize.examensarbete.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "weeks")
public class Week {

    @Id
    @Column(name = "week_id", nullable = false)
    private Long weekId;


    @Column (name = "userPlanDay" )
    private String userPlanDay;

    @Column(name="user_id")
    private Long userId;

    public Week(Long weekId, String userPlanDay, Long userId) {
        this.weekId = weekId;
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