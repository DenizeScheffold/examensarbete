package se.denize.examensarbete.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import se.denize.examensarbete.authorities.UserRoles;
import se.denize.examensarbete.controller.UserController;
import se.denize.examensarbete.model.User;
import se.denize.examensarbete.repository.UserRepository;
import se.denize.examensarbete.serviceImpl.UserServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    //@Autowired
    //private UserServiceImpl userService;

    @MockBean
    private UserRepository userRepository;

    /*
    @BeforeEach
    void setUp() {
        User user = User.builder()
                .username("mockis")
                .email("mock@mocke.se")
                .role(UserRoles.ADMIN)
                .isAccountNonLocked(false)
                .isAccountNonExpired(false)
                .isCredentialsNonExpired(false)
                .isEnabled(false)
                .password("abb")
                .build();

        Mockito.when(userRepository.findByUsername("mockis"))
                .thenReturn(user);
    }

     */

    @Test
    public void whenValidUsername_thenUsernameShouldFound(){
        UserServiceImpl userService = Mockito.mock(UserServiceImpl.class);
        AuthService authService = Mockito.mock(AuthService.class);
        UserController userController = new UserController(userService, authService);
        String username = "Stinis";
        User found = userService.loadUserByUsername(username);
        assertEquals(username,found.getUsername());
    }


}