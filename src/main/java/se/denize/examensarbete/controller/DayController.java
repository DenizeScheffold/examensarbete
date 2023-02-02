package se.denize.examensarbete.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.denize.examensarbete.model.Day;
import se.denize.examensarbete.service.DayService;


import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class DayController {

    private final DayService dayService;


    @GetMapping("/user/{userId}/plan")
    public List<Day> getPlanFromUser(@PathVariable("userId") long userId) {
        return dayService.getPlanFromUser(userId);
    }

    @PostMapping("/setPlan")
    public ResponseEntity<Day> setPlan(@RequestBody Day day) {
        return dayService.savePlan(day);
    }

    @PostMapping("/setPlans")
    public ResponseEntity<List<Day>> setPlans(@RequestBody List<Day> days) {
        return dayService.savePlans(days);
    }

    @GetMapping("/getPlans")
    private ResponseEntity<Day> getAllPlanDays() {
        return dayService.getPlanDays();
    }

    @DeleteMapping("/removePlanByDayId/{dayId}")
    private ResponseEntity<Day> removePlanDayId(@PathVariable("dayId") long dayId) {
        return dayService.deleteByDayId(dayId);
    }

    @PatchMapping("/editDay/{dayId}")
    private ResponseEntity<Day> editDay(@RequestBody Day day, @PathVariable long dayId) {
        return dayService.editDay(day, dayId);
    }

    @GetMapping("/getFullWeek/{weekNumber}")
    private ResponseEntity<Day> getFullWeek(@PathVariable("weekNumber") int weekNumber) {
        return dayService.getFullWeek(weekNumber);
    }

    @GetMapping("/getPlanForUser1/{weekNumber}")
    private ResponseEntity<List<Day>> getUser1FullWeek(@PathVariable("weekNumber") int weekNumber) {
        return dayService.getUser1FullWeek(weekNumber, 1);
    }

    @GetMapping("getPlanForUser2/{weekNumber}")
    private ResponseEntity<List<Day>> getUser2FullWeek(@PathVariable("weekNumber") int weekNumber) {
        return dayService.getUser2FullWeek(weekNumber, 2);
    }

    @GetMapping("/getWeekFromBefore/weekNumber/userId")
    private List<Day> getWeekFromBeforeDB(@PathVariable("weekNumber") int weekNumber, @PathVariable("userId") long userId) {
        return dayService.getWeekBeforeFromDB(weekNumber, userId);
    }


}