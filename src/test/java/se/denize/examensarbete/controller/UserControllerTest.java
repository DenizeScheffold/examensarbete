package se.denize.examensarbete.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import se.denize.examensarbete.authorities.UserRoles;
import se.denize.examensarbete.model.User;
import se.denize.examensarbete.repository.UserRepository;
import se.denize.examensarbete.service.AuthService;
import se.denize.examensarbete.serviceImpl.UserServiceImpl;


import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@AutoConfigureMockMvc
@WebMvcTest(UserController.class)
class UserControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @MockBean
        private UserRepository userRepository;

        @MockBean
        private UserServiceImpl userService;

        @MockBean
        private AuthService authService;

    private User user;

    @BeforeEach
    void setUp() {
        user = User.builder()
                .userId(10L)
                .username("mockis")
                .email("mock@mocke.se")
                .role(UserRoles.ADMIN)
                .isAccountNonLocked(false)
                .isAccountNonExpired(false)
                .isCredentialsNonExpired(false)
                .isEnabled(false)
                .password("abb")
                .build();
    }


    @Test
    public void getUserByFirstName() throws Exception {

        //List<User> allUsers = Arrays.asList(user);
        when(userService.findUserById(10)).thenReturn(Optional.ofNullable(user));

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/getUsernameFromId/10")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "{username: \"mockis\" }";
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
                //result.getResponse().getContentAsString(), false);
    }

    @Test
    void saveUser(){

    }

    @Test
    void fetchUserById() throws Exception {
        this.mockMvc.perform(get("/api/getUsernameFromId/1803")).andDo(print()).andExpect(status().isOk())
                .andExpect((ResultMatcher) content().string("Kattis"));
    }
}