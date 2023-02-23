package se.denize.examensarbete.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import se.denize.examensarbete.model.Day;
import se.denize.examensarbete.model.User;
import se.denize.examensarbete.serviceImpl.DayServiceImpl;
import se.denize.examensarbete.serviceImpl.UserServiceImpl;


import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DayController {

    private final DayServiceImpl dayService;
    private final UserServiceImpl userService;
 //   private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());
    @GetMapping("/getDaysNotSet/{weekNumber}/{userId}")
    public  List<Day>findDaysWithoutResponse(@PathVariable("userId") long userId, @PathVariable("weekNumber")int weekNumber){
        return dayService.findDaysWithoutResponse(userId, weekNumber);
    }
//@AuthenticationPrincipal User user
    @GetMapping("/getUserId")
    public String findLoggedInUser(){
        //log.info("Get current user: {}" + user.getUserId());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            return currentUserName;
        }
        return "not found...";
    }
    //IS WORKING
    @GetMapping("/getPlanForProcessUser/")
    public ResponseEntity<List<Day>> findDaysReadyForProcessBothUser(@AuthenticationPrincipal(expression = "@userService.getUser(#this)") User user){
        User otherParent = userService.findOtherParent(user.getUserId());
        long otherParentId = otherParent.getUserId();
        return dayService.findDaysReadyForProcessBothUser(user.getUserId(), otherParentId );
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