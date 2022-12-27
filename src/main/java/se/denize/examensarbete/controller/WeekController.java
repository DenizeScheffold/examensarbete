package se.denize.examensarbete.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import se.denize.examensarbete.model.User;
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
    public void getPlan() {
     weekService.comparePlans((new User("Stina@gmail.com", 2L, List.of("MONDAY-RED", "MONDAY-GREEN"))), (new User("Rut@hotmail.com", 1L, List.of("MONDAY-RED", "MONDAY-GREEN"))));
    }

}
