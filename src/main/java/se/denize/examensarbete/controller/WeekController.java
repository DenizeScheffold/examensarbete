package se.denize.examensarbete.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import se.denize.examensarbete.model.Day;
import se.denize.examensarbete.service.WeekService;


import java.util.List;


@RestController
@RequestMapping("/api")
public class WeekController {

    private final WeekService weekService;

    @Autowired
    public WeekController(WeekService weekService) {
        this.weekService = weekService;
    }


    @PostMapping("/setPlan")
    public ResponseEntity<Day> setPlan(@RequestBody Day day) {
        return weekService.savePlan(day);
        //  weekService.comparePlans((new User("Stina@gmail.com", 2L, List.of("MONDAY-RED", "MONDAY-GREEN"))), (new User("Rut@hotmail.com", 1L, List.of("MONDAY-RED", "MONDAY-GREEN"))));
    }

    @PostMapping("/setPlans")
    public ResponseEntity<List<Day>> setPlans(@RequestBody List<Day> days) {
        return weekService.savePlans(days);
    }

    @GetMapping("/getPlans")
    private ResponseEntity<Day> getAllPlanDays() {
        return weekService.getPlanDays();
    }

    @DeleteMapping("/removePlanByDayId/{dayId}")
    private ResponseEntity<Day> removePlanDayId(@PathVariable("dayId") long dayId) {
        return weekService.deleteByDayId(dayId);
    }

    @PatchMapping("/editDay/{dayId}")
    private ResponseEntity<Day> editDay(@RequestBody Day day, @PathVariable long dayId) {
        return weekService.editDay(day, dayId);
    }

    @GetMapping("/getFullWeek/{weekNumber}")
    private ResponseEntity<Day> getFullWeek(@PathVariable("weekNumber") int weekNumber) {
        return weekService.getFullWeek(weekNumber);
    }
/*
    @GetMapping("api/getUserFullWeek/{weekNumber}/{userId}")
    private List<Day> getUserFullWeek(@PathVariable("weekNumber") long weekNumber, @PathVariable("userId") long userId) {
       return weekService.getUserFullWeek(weekNumber, userId);
    }

 */

    @GetMapping("/getPlanForUser1/{weekNumber}")
    private ResponseEntity<List<Day>> getUser1FullWeek(@PathVariable("weekNumber") int weekNumber) {
        return weekService.getUser1FullWeek(weekNumber, 1);
        //calculatePlansService.setDaysForUser1(daysForUser1);


    }

    @GetMapping("getPlanForUser2/{weekNumber}")
    private ResponseEntity<List<Day>> getUser2FullWeek(@PathVariable("weekNumber") int weekNumber) {
        //List<Day> daysForUser2 = weekService.getUser2FullWeek(weekNumber, 2);
        //calculatePlansService.setDaysForUser2(daysForUser2);
        return weekService.getUser2FullWeek(weekNumber, 2);
    }

    @GetMapping("/getWeekFromBefore/weekNumber/userId")
    private List<Day> getWeekFromBeforeDB(@PathVariable("weekNumber") int weekNumber, @PathVariable("userId") long userId) {
        return weekService.getWeekBeforeFromDB(weekNumber, userId);
    }


}