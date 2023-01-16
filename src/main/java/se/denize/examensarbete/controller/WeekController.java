package se.denize.examensarbete.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import se.denize.examensarbete.model.CalculatePlans;
import se.denize.examensarbete.model.Day;
import se.denize.examensarbete.service.WeekService;


import java.util.List;


@Controller
public class WeekController {

    private final WeekService weekService;

    @Autowired
    public WeekController(WeekService weekService) {
        this.weekService = weekService;
    }


    @PostMapping("/api/setPlan")
    public ResponseEntity<Day> setPlan(@RequestBody Day day) {
        return weekService.savePlan(day);
        //  weekService.comparePlans((new User("Stina@gmail.com", 2L, List.of("MONDAY-RED", "MONDAY-GREEN"))), (new User("Rut@hotmail.com", 1L, List.of("MONDAY-RED", "MONDAY-GREEN"))));
    }

    @PostMapping("/api/setPlans")
    public ResponseEntity<List<Day>> setPlans(@RequestBody List<Day> days){
        return weekService.savePlans(days);
    }

    @GetMapping("api/getPlans")
    private ResponseEntity<Day> getAllPlanDays() {
        return weekService.getPlanDays();
    }

    @DeleteMapping("api/removePlanByWeekId/{weekId}")
    private ResponseEntity<Day> removePlanByWeekId(@PathVariable("weekId") long weekId) {
        return weekService.deleteByWeekId(weekId);
    }

    @PatchMapping("/api/editDay/{weekId}")
    private ResponseEntity editWeek(@RequestBody Day day, @PathVariable long weekId) {
        return weekService.editWeek(day, weekId);
    }

    @GetMapping("api/getFullWeek/{weekNumber}")
    private ResponseEntity<Day> getFullWeek(@PathVariable("weekNumber") long weekNumber) {
        return weekService.getFullWeek(weekNumber);
    }
/*
    @GetMapping("api/getUserFullWeek/{weekNumber}/{userId}")
    private List<Day> getUserFullWeek(@PathVariable("weekNumber") long weekNumber, @PathVariable("userId") long userId) {
       return weekService.getUserFullWeek(weekNumber, userId);
    }

 */


    @GetMapping("api/getPlanForUser1/{weekNumber}")
    private  ResponseEntity<List<Day>> getUser1FullWeek(@PathVariable("weekNumber") long weekNumber) {
        return weekService.getUser1FullWeek(weekNumber, 1);
        //calculatePlansService.setDaysForUser1(daysForUser1);


    }

    @GetMapping("api/getPlanForUser2/{weekNumber}")
    private ResponseEntity<List<Day>> getUser2FullWeek(@PathVariable("weekNumber") long weekNumber) {
        //List<Day> daysForUser2 = weekService.getUser2FullWeek(weekNumber, 2);
        //calculatePlansService.setDaysForUser2(daysForUser2);
        return weekService.getUser2FullWeek(weekNumber, 2);
    }

}