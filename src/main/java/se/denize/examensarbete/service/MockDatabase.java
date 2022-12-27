package se.denize.examensarbete.service;

import se.denize.examensarbete.model.Weekday;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MockDatabase {

    public Map<Weekday, String> userAdb(){
        return Stream.of(new Object[][] {
                {Weekday.MONDAY, "Y"},
                {Weekday.MONDAY, "N"},
                {Weekday.TUESDAY, "N"},
                {Weekday.TUESDAY, "N"},
        }).collect(Collectors.toMap(data -> (Weekday) data[0], data -> (String) data[1]));
    }

    public Map<Weekday, String> userBdb(){

        return Stream.of(new Object[][] {
                    {Weekday.MONDAY, "N"},
                    {Weekday.MONDAY, "Y"},
                    {Weekday.TUESDAY, "Y"},
                    {Weekday.TUESDAY, "Y"},
            }).collect(Collectors.toMap(data -> (Weekday) data[0], data -> (String) data[1]));

    }


    }

