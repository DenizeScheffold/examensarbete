package se.denize.examensarbete.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import se.denize.examensarbete.authorities.UserRoles;
import se.denize.examensarbete.model.User;
import se.denize.examensarbete.service.AuthService;


@WebMvcTest(JwtAuthenticationController.class)
class JwtAuthenticationControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthService authService;

    private User user;

    @BeforeEach
    void setUp() {

        user = User.builder()
                .username("mockis")
                .email("mock@mocke.se")
                .role(UserRoles.ADMIN)
                .isAccountNonLocked(false)
                .isAccountNonExpired(false)
                .isCredentialsNonExpired(false)
                .isEnabled(false)
                .password("abb")
                .userId(10L)
                .build();
    }


    @Test
    void saveUser() throws Exception {

        User inputUser = User.builder()
                .username("mockis")
                .email("mock@mocke.se")
                .password("abb")
                .build();

       // Mockito.when(authService.createUser(inputUser))
            //    .thenReturn(user);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/saveUser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(" { \"email\": \"siv@sivan.se\",\n" +
                        "        \"otherParentId\": 2,\n" +
                        "        \"username\": \"siv\",\n" +
                        "        \"password\": \"abb\",\n" +
                        "        \"role\": \"ADMIN\"\n" +
                        "        \n" +
                        "\n" +
                        "    }"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}