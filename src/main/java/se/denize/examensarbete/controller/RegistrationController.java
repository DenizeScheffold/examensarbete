package se.denize.examensarbete.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import se.denize.examensarbete.model.RegistrationService;
import se.denize.examensarbete.serviceImpl.RegistrationRequest;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;
/*
    @PostMapping
    public String register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }
*/
}
