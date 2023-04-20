package se.denize.examensarbete.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.util.ReflectionTestUtils;
import se.denize.examensarbete.ExamensarbeteApplication;
import se.denize.examensarbete.dataObjects.UserDAO;
import se.denize.examensarbete.model.User;
import se.denize.examensarbete.serviceImpl.UserServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = ExamensarbeteApplication.class)
public class ServiceTest {


    @Autowired
    ApplicationContext context;

    @Autowired
    User user1;

    @Autowired
    User user2;

    @MockBean
    private UserDAO userDAO;

    @Autowired
    private UserServiceImpl userService;


    @BeforeEach
    public void beforeEach(){
       user1.setUserId(1L);
       user1.setUsername("Alexis");
       user1.setOtherParentId(2L);
       user1.setEmail("alexis@alex.se");
       user2.setUserId(2L);
       user2.setUsername("Elis");
       user2.setOtherParentId(1L);
       user2.setEmail("eli@elis.se");

      //  ReflectionTestUtils.setField(user1, "userId", 1L);


    }


    @DisplayName("load user by username")
    @Test
    public void getUserFromUserName(){
        when(userDAO.loadUserByUsername("Alexis"))
                .thenReturn(user1);
        assertEquals(user1.getUserId(), userService.loadUserByUsername("Alexis").getUserId());
    }

    @Test
    public void getUserFromUserNameReflection(){
        assertEquals(user1, ReflectionTestUtils.invokeMethod(user1.getUsername(),"loadUserByUsername"));
    }

    @Test
    public void getOtherParentId(){
        assertEquals(user2.getUserId(),
                (Long) ReflectionTestUtils.invokeMethod(user1.getUserId(), "findOtherParent", "pass if found"));
    }

    /*
    @DisplayName("get other parent")
    @Test
    public void getOtherParent(){
        when(userDAO.findOtherParent(user1.getUserId()))
    }

     */



}
