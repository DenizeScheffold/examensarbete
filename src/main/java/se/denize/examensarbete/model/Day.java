package se.denize.examensarbete.model;

import jakarta.persistence.*;


//TODO: ändra tabellnamn till days och även weekid till dayid
@Entity
@Table(name = "days")
public class Day {


    //TODO: make weekId calculate from userId + date + 1 for hämta/2 for lämna Ex: 12301091
    @Id
    @Column(name = "week_id", nullable = false)
    private Long dayId;

    @Column (name = "plan_day" )
    private String planDay;

    @Column (name = "week_number")
    private Long weekNumber;

    @Column(name="user_id")
    private Long userId;

    private String dayName;

    public Day(Long dayId, Long weekNumber, String planDay, Long userId) {
        this.dayId = dayId;
        this.weekNumber = weekNumber;
        this.planDay = planDay;
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

    public String getPlanDay() {
        return planDay;
    }

    public void setPlanDay(String planDay) {
        this.planDay = planDay;
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


    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    @Override
    public String toString() {
        return "Day{" +
                "dayId=" + dayId +
                ", planDay='" + planDay + '\'' +
                ", weekNumber=" + weekNumber +
                ", userId=" + userId +
                '}';
    }
}

