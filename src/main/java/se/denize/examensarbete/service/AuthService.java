package se.denize.examensarbete.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;
import se.denize.examensarbete.authentication.JwtTokenResponse;
import se.denize.examensarbete.authentication.JwtTokenService;
import se.denize.examensarbete.authentication.UserRequest;
import se.denize.examensarbete.authorities.UserRoles;
import se.denize.examensarbete.configurations.AppPasswordConfig;
import se.denize.examensarbete.model.User;
import se.denize.examensarbete.repository.UserRepository;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final AppPasswordConfig passwordConfig;
   // private final JwtTokenService jwtService;
   // private final AuthenticationManager authenticationManager;

    public void createUser(UserRequest requestBody) {
        User user = User.builder()
                .username(requestBody.getUsername())
                .otherParentId(requestBody.getOtherParentId())
                .email(requestBody.getEmail())
                .password(passwordConfig.bCryptPasswordEncoder().encode(requestBody.getPassword()))
                .role(UserRoles.valueOf(requestBody.getRole()))
                .build();
        userRepository.save(user).getUserId();
      //   var jwtToken = jwtService.generateToken();

    }
}
