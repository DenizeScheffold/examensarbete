package se.denize.examensarbete.serviceImpl;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import se.denize.examensarbete.dataObjects.UserDAO;
import se.denize.examensarbete.model.User;
import se.denize.examensarbete.service.UserService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserDAO userDao;



    @Override
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = new ArrayList<>(userDao.findAllUsers());
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    //TODO check if user already exists
    @Override
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        try {
            User userSaved = userDao.save(user);
            return new ResponseEntity<>(userSaved, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<User> deleteUser(long userId) {
        try {
            userDao.deleteById(userId);
            return new ResponseEntity("User deleted: " + userId, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("User not found" + e, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<User> editUser(User user, long userId) {

        User userInDB = userDao.findById(userId).get();

        if (Objects.nonNull(user.getEmail()))
            userInDB.setEmail(user.getEmail());

        if (Objects.nonNull(user.getOtherParentId()))
            userInDB.setOtherParentId(user.getOtherParentId());

        return new ResponseEntity<>(userDao.save(userInDB), HttpStatus.OK);
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDao.loadUserByUsername(username);
    }

}



