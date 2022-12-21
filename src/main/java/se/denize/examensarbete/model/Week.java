package se.denize.examensarbete.model;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Getter
@Setter
public class Week {

    private Map<Weekday, String> planUserA = new LinkedHashMap<>();
    private List<String> planUserB;
    private Long weekId;



    public void setPlanUserA() {
        Map<Weekday, String> planUserA = Stream.of(new Object[][] {

            {Weekday.MONDAY, "Y"},
            {Weekday.TUESDAY, "Y"},
            }).collect(Collectors.toMap(data -> (Weekday) data[0], data -> (String) data[1]));

        System.out.println(planUserA.entrySet());

    }

}