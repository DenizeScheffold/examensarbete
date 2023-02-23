package se.denize.examensarbete.service;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import se.denize.examensarbete.model.User;

import java.util.List;


public interface UserService {
    ResponseEntity<List<User>> getAllUsers();

    ResponseEntity<User> saveUser(User user);

    ResponseEntity<User> deleteUser(long userId);

    ResponseEntity<User> editUser(User user, long userId);

    User loadUserByUsername(String username);

    Long findCurrentUserIdFromToken();

}
