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

    @ElementCollection
    private List<String> commonPlan;

    public void comparePlans(List<String> userA, List<String> userB) {
        //TODO use WeekService to compare plans. Return conflicts.
    }

    public void setPlan(List<String> conflicts){
        //TODO
    }
}