package se.denize.examensarbete.model;

import jakarta.persistence.*;

import java.sql.Date;

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

    @Column(name = "date")
    private String date;

    @Column(name= "activity")
    private Integer activity;

    @Column(name = "possible")
    private Boolean possible;


    public Day(Integer weekNumber, Long userId, String date, Integer activity, Boolean possible) {
        this.weekNumber = weekNumber;
        this.userId = userId;
        this.date = date;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
                ", date='" + date + '\'' +
                ", activity=" + activity +
                ", possible=" + possible +
                '}';
    }
}

