package se.denize.examensarbete.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "days")
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dayid", nullable = false)
    private Long dayId;

    @Column(name = "week_number")
    private Integer weekNumber;

    @Column(name = "userid")
    private Long userId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private LocalDate dayDate;

    @Column(name = "activity")
    private Integer activity;

    @Column(name = "possible")
    private Boolean possible;

    @Column(name = "processed")
    private Boolean processed;


    public Day(Integer weekNumber, Long userId, LocalDate dayDate, Integer activity, Boolean possible, Boolean processed) {
        this.weekNumber = weekNumber;
        this.userId = userId;
        this.dayDate = dayDate;
        this.activity = activity;
        this.possible = possible;
        this.processed = processed;
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

    public LocalDate getDayDate() {
        return dayDate;
    }

    public void setDayDate(LocalDate dayDate) {
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

    public Boolean getProcessed() {
        return processed;
    }

    public void setProcessed(Boolean processed) {
        this.processed = processed;
    }

}

