package se.denize.examensarbete.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import se.denize.examensarbete.model.Day;
import se.denize.examensarbete.model.User;
import se.denize.examensarbete.serviceImpl.DayServiceImpl;
import se.denize.examensarbete.serviceImpl.UserServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DayController {

    private final DayServiceImpl dayService;
    private final UserServiceImpl userService;

    @GetMapping("/getDaysNotSet/{weekNumber}/{userId}")
    public  List<Day>findDaysWithoutResponse(@PathVariable("userId") long userId, @PathVariable("weekNumber")int weekNumber){
        return dayService.findDaysWithoutResponse(userId, weekNumber);
    }

    //IS WORKING
    @GetMapping("/getPlanForProcessUser/")
    public ResponseEntity<List<Day>> findDaysReadyForProcessBothUser(){
        long userId = userService.findCurrentUserId();
        User otherParent = userService.findOtherParent(userId);
        return dayService.findDaysReadyForProcessBothUser(userId, otherParent.getUserId());
    }


    @PostMapping("/setPlan")
    public ResponseEntity<Day> setPlan(@RequestBody Day day) {
        return dayService.savePlan(day);
    }

    @PostMapping("/setPlans")
    public ResponseEntity<List<Day>> setPlans(@RequestBody List<Day> days) {
        return dayService.savePlans(days);
    }
    @DeleteMapping("/removePlanByDayId/{dayId}")
    private ResponseEntity<Day> removePlanDayId(@PathVariable("dayId") long dayId) {
        return dayService.deleteByDayId(dayId);
    }

    @PatchMapping("/editDay/{dayId}")
    private ResponseEntity<Day> editDay(@RequestBody Day day, @PathVariable long dayId) {
        return dayService.editDay(day, dayId);
    }


}