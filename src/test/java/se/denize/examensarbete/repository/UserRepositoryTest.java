package se.denize.examensarbete.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import se.denize.examensarbete.authorities.UserRoles;
import se.denize.examensarbete.model.User;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;
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

        entityManager.persist(user);
    }


    @Test
    public void whenFindByUsername_thenReturnUser(){
        User user = userRepository.findByUsername("mockis");
        assertEquals(user.getUsername(), "mockis" );
    }
}