package se.denize.examensarbete.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import se.denize.examensarbete.model.Day;
import se.denize.examensarbete.serviceImpl.WeekServiceImpl;



@Controller
public class WeekController {

    private final WeekServiceImpl weekService;

    @Autowired
    public WeekController(WeekServiceImpl weekService) {
        this.weekService = weekService;
    }


    @PostMapping("/api/setPlan")
    public ResponseEntity<Day> getPlan(@RequestBody Day day) {
        return weekService.savePlan(day);
        //  weekService.comparePlans((new User("Stina@gmail.com", 2L, List.of("MONDAY-RED", "MONDAY-GREEN"))), (new User("Rut@hotmail.com", 1L, List.of("MONDAY-RED", "MONDAY-GREEN"))));
    }

    @GetMapping("api/getPlans")
    private ResponseEntity<Day> getAllPlanDays() {
        return weekService.getPlanDays();
    }

    @DeleteMapping("api/removePlanByWeekId/{weekId}")
    private ResponseEntity<Day> removePlanByWeekId(@PathVariable("weekId") long weekId){
        return weekService.deleteByWeekId(weekId);
    }

    @PatchMapping("/api/editDay/{weekId}")
    private ResponseEntity editWeek(@RequestBody Day day, @PathVariable long weekId){
        return weekService.editWeek(day, weekId);
    }

    @GetMapping("api/getFullWeek/{weekNumber}")
    private ResponseEntity<Day> getFullWeek(@PathVariable("weekNumber") long weekNumber){
        return weekService.getFullWeek(weekNumber);
    }

    @GetMapping("api/getUserFullWeek/{weekNumber}/{userId}")
    private ResponseEntity<Day> getUserFullWeek(@PathVariable("weekNumber") long weekNumber, @PathVariable("userId") long userId) {
       return weekService.getUserFullWeek(weekNumber, userId);
    }

}
