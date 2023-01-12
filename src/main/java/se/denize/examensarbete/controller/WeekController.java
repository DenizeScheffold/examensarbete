package se.denize.examensarbete.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import se.denize.examensarbete.model.Week;
import se.denize.examensarbete.serviceImpl.WeekServiceImpl;

import java.util.List;

@Controller
public class WeekController {

    private final WeekServiceImpl weekService;

    @Autowired
    public WeekController(WeekServiceImpl weekService) {
        this.weekService = weekService;
    }


    @PostMapping("/api/setPlan")
    public ResponseEntity<Week> getPlan(@RequestBody Week week) {
        return weekService.savePlan(week);
        //  weekService.comparePlans((new User("Stina@gmail.com", 2L, List.of("MONDAY-RED", "MONDAY-GREEN"))), (new User("Rut@hotmail.com", 1L, List.of("MONDAY-RED", "MONDAY-GREEN"))));
    }

    @GetMapping("api/getPlans")
    private ResponseEntity<Week> getAllPlanDays() {
        return weekService.getPlanDays();
    }

    @DeleteMapping("api/removePlanByWeekId/{weekId}")
    private ResponseEntity<Week> removePlanByWeekId(@PathVariable("weekId") long weekId){
        return weekService.deleteByWeekId(weekId);
    }
}
