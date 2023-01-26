package se.denize.examensarbete.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "days")
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dayid", nullable = false)
    private Long dayId;

    @Column (name = "week_number")
    private Integer weekNumber;

    @Column(name="userid")
    private Long userId;
    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date dayDate;

    @Column(name= "activity")
    private Integer activity;

    @Column(name = "possible")
    private Boolean possible;


    public Day(Integer weekNumber, Long userId, Date dayDate, Integer activity, Boolean possible) {
        this.weekNumber = weekNumber;
        this.userId = userId;
        this.dayDate = dayDate;
        this.activity = activity;
        this.possible = possible;
    }

    public Day() {
    }

    public Long getDayId() {
        return dayId;
    }

    public Integer getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(Integer weekNumber) {
        this.weekNumber = weekNumber;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getDayDate() {
        return dayDate;
    }

    public void setDayDate(Date dayDate) {
        this.dayDate = dayDate;
    }

    public Integer getActivity() {
        return activity;
    }

    public void setActivity(Integer activity) {
        this.activity = activity;
    }

    public Boolean getPossible() {
        return possible;
    }

    public void setPossible(Boolean possible) {
        this.possible = possible;
    }

    @Override
    public String toString() {
        return "Day{" +
                "dayId=" + dayId +
                ", weekNumber=" + weekNumber +
                ", userId=" + userId +
                ", date='" + dayDate + '\'' +
                ", activity=" + activity +
                ", possible=" + possible +
                '}';
    }
}

