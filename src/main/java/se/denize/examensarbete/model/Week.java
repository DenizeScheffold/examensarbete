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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "week_id", nullable = false)
    private Long weekId;

   // private Long weekNumber;

    @ElementCollection
    @Column
    private List<String> userPlan;

    @Column(name="user_id")
    private Long userId;

    public Week(List<String> userPlan, Long userId) {
        this.userPlan = userPlan;
        this.userId = userId;
    }

    public Week() {
    }


/*
    public Long getWeekId() {
        return weekId;
    }

    public void setWeekId(Long weekId) {
        StringBuilder sb = new StringBuilder();
        weekId = sb.append(userId).append(weekNumber);
        this.weekId = weekId;
    }

    public Long getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(Long weekNumber) {
        this.weekNumber = weekNumber;
    }
  */

    public List<String> getUserPlan() {
        return userPlan;
    }

    public void setUserPlan(List<String> userPlan) {
        //TODO: parse incoming json and set to a List to return.
        this.userPlan = userPlan;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


//private Map<Weekday, String> planUser;


    /*
    private Map<Weekday, String> planUserA = new LinkedHashMap<>();
    private List<String> planUserB;


    public void setPlanUserA() {
        Map<Weekday, String> planUserA = Stream.of(new Object[][] {

            {Weekday.MONDAY, "Y"},
            {Weekday.TUESDAY, "Y"},
            }).collect(Collectors.toMap(data -> (Weekday) data[0], data -> (String) data[1]));



    }*/

}