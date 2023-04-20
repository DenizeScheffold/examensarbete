package se.denize.examensarbete.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import se.denize.examensarbete.model.User;

import java.util.List;
import java.util.Optional;


@Service
public interface UserService {
    ResponseEntity<List<User>> getAllUsers();

    ResponseEntity<User> deleteUser(long userId);

    ResponseEntity<User> editUser(User user, long userId);

    User loadUserByUsername(String username);

    Long findCurrentUserIdFromToken();

    User findCurrentUserFromToken();

    User findOtherParent(long userId);

    Optional<User> findUserById(long userId);

}
