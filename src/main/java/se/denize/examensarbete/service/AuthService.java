package se.denize.examensarbete.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se.denize.examensarbete.authorities.UserRoles;
import se.denize.examensarbete.configurations.AppPasswordConfig;
import se.denize.examensarbete.model.User;
import se.denize.examensarbete.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final AppPasswordConfig passwordConfig;

    public void createUser(User requestBody) {
         User userToDB = new User();
         userToDB= User.builder()
                .username(requestBody.getUsername())
                .otherParentId(requestBody.getOtherParentId())
                .email(requestBody.getEmail())
                .password(passwordConfig.bCryptPasswordEncoder().encode(requestBody.getPassword()))
                .role(UserRoles.valueOf(String.valueOf(requestBody.getRole())))
                 .isAccountNonExpired(true)
                 .isAccountNonLocked(true)
                 .isCredentialsNonExpired(true)
                 .isEnabled(true)
                .build();
        userRepository.save(userToDB).getUserId();

    }
}
