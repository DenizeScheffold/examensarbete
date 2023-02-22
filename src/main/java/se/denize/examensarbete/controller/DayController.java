package se.denize.examensarbete.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import se.denize.examensarbete.model.Day;
import se.denize.examensarbete.model.User;
import se.denize.examensarbete.service.DayService;
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
    @GetMapping("/user/{userId}/plan")
    public List<Day> getPlanAlreadySetFromUser(@PathVariable("userId") long userId) {
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
    //@PreAuthorize("hasRole('ADMIN')")
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

    @GetMapping("/getPlanForProcess/{userId}")
    private ResponseEntity<List<Day>> findDaysReadyForProcessPrimaryUser(@PathVariable("userId") long userId){
        return dayService.findDaysReadyForProcessPrimaryUser(userId);
    }

    //THIS IS THE ONE that is working with calculation!!!
    //TODO: debug
    //TODO: is processed working?
    //TODO: is possible changing?
    @GetMapping("/getPlanForProcess/{userId}/{otherParentId}")
    private ResponseEntity<List<Day>> findDaysReadyForProcessBothUser(@PathVariable("userId") long userId, @PathVariable("otherParentId") long otherParentId){
        return dayService.findDaysReadyForProcessBothUser(userId, otherParentId);
    }

    //THIS MIGHT ALSO WORK.
    //TODO: debug
    //TODO: is processed working?
    //TODO: is possible changing?
    @GetMapping("/getPlanForProcessUser/{userId}")
    private ResponseEntity<List<Day>> TRYFORIMPOVEfindDaysReadyForProcessBothUser(@PathVariable("userId") long userId){
        User otherParent = userService.findOtherParent(userId);
        return dayService.findDaysReadyForProcessBothUser(userId, otherParent.getOtherParentId());
    }

    @GetMapping("/getPlanForProcessSecondaryUser/{userId}")
    private ResponseEntity<List<Day>> findDaysReadyForProcessSecondaryUser(@PathVariable("userId") long userId){
        User otherParent = userService.findOtherParent(userId);
        return dayService.findDaysReadyForProcessPrimaryUser(otherParent.getUserId());
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