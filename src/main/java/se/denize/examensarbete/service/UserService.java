package se.denize.examensarbete.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import se.denize.examensarbete.model.User;

import java.util.List;


@Service
public interface UserService {
    ResponseEntity<List<User>> getAllUsers();

    ResponseEntity<User> deleteUser(long userId);

    ResponseEntity<User> editUser(User user, long userId);

    User loadUserByUsername(String username);

    Long findCurrentUserIdFromToken();

    User findCurrentUserFromToken();
}
