package se.denize.examensarbete.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
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


    //IS WORKING
    @GetMapping("/getDaysNotSet/{weekNumber}")
    public  ResponseEntity<List<Day>>findDaysWithoutResponse(@PathVariable("weekNumber")int weekNumber){
        return dayService.findDaysWithoutResponse(userService.findCurrentUserIdFromToken(), weekNumber);
    }

    //IS WORKING
    @GetMapping("/getPlanForProcessUser")
    public ResponseEntity<List<Day>> findDaysReadyForProcessBothUser(){
        //finds userdetails from token
        long userId = userService.findCurrentUserIdFromToken();
        User otherParent = userService.findOtherParent(userId);
        return dayService.findDaysReadyForProcessBothUser(userId, otherParent.getUserId());
    }

@GetMapping("/getCompletePlan")
    public ResponseEntity<List<Day>> findDaysProcessed(){
        //finds userdetails from token
        long userId = userService.findCurrentUserIdFromToken();
        return dayService.findDaysProcessed(userId);
}

@GetMapping("/getCompletePlanForOtherParent")
    public ResponseEntity<List<Day>> findDaysProcessedOtherParent(){
        //finds userdetails from token
        long userId = userService.findCurrentUserIdFromToken();
        User otherParent = userService.findOtherParent(userId);
        return dayService.findDaysProcessed(otherParent.getUserId());
}


@GetMapping("/getCompletePlanOnlyTrueBothParents/{weekNumber}")
public ResponseEntity<List<Day>> findDaysBothParentsTrue(@PathVariable("weekNumber") int weekNumber){
    long userId = userService.findCurrentUserIdFromToken();
    User otherParent = userService.findOtherParent(userId);
    return dayService.findDaysProcessedBothUserTrue(userId, otherParent.getUserId(), weekNumber);

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