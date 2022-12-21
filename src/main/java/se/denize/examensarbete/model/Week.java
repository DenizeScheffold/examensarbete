package se.denize.examensarbete.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
@Getter
@Setter
@Table(name="weeks")
public class Week {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

/*
    private Map<Weekday, String> planUserA = new LinkedHashMap<>();
    private List<String> planUserB;


    public void setPlanUserA() {
        Map<Weekday, String> planUserA = Stream.of(new Object[][] {

            {Weekday.MONDAY, "Y"},
            {Weekday.TUESDAY, "Y"},
            }).collect(Collectors.toMap(data -> (Weekday) data[0], data -> (String) data[1]));

        System.out.println(planUserA.entrySet());

    }*/

}