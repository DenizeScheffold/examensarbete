package se.denize.examensarbete.model;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.denize.examensarbete.serviceImpl.ConfirmationTokenService;
import se.denize.examensarbete.serviceImpl.RegistrationRequest;
import se.denize.examensarbete.serviceImpl.UserServiceImpl;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final UserServiceImpl userService;

    private final ConfirmationTokenService confirmationTokenService;

 /*

    public String register(RegistrationRequest request) {



        String token = userService.signUpUser(
                new User(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPassword(),
                        Role.USER

                )
        );

        String link = "http://localhost:8080/api/v1/registration/confirm?token=" + token;
        return token;
    }

    @Transactional
    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService
                .getToken(token)
                .orElseThrow(() ->
                        new IllegalStateException("token not found"));

        if (confirmationToken.getConfirmedAt() != null) {
            throw new IllegalStateException("email already confirmed");
        }

        LocalDateTime expiredAt = confirmationToken.getExpiresAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("token expired");
        }

        confirmationTokenService.setConfirmedAt(token);
        userService.enableUser(
                confirmationToken.getUser().getEmail());
        return "confirmed";

    }
         */

}
