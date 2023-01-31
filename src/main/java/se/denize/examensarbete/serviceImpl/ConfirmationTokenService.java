package se.denize.examensarbete.serviceImpl;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import se.denize.examensarbete.model.ConfirmationToken;
import se.denize.examensarbete.repository.ConfirmationTokenRepository;

import java.time.LocalDateTime;
import java.util.Optional;


@Service
@AllArgsConstructor
public class ConfirmationTokenService {

    private final ConfirmationTokenRepository confirmationTokenRepository;

    public void saveConfirmationToken(ConfirmationToken token) {
        confirmationTokenRepository.save(token);
    }

    public Optional<ConfirmationToken> getToken(String token) {
        return confirmationTokenRepository.findByToken(token);
    }

    public int setConfirmedAt(String token) {
        return confirmationTokenRepository.updateConfirmedAt(
                token, LocalDateTime.now());
    }
}
