package se.denize.examensarbete.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import se.denize.examensarbete.dataObjects.UserModelDAO;
import se.denize.examensarbete.model.User;
import se.denize.examensarbete.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserModelDAO userModelDAO;

    @Autowired
    public UserServiceImpl(UserModelDAO userModelDAO) {
        this.userModelDAO = userModelDAO;
    }


    @Override
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = new ArrayList<>(userModelDAO.findAllUsers());
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    //TODO check if user already exists
    @Override
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        try {
            User userSaved = userModelDAO.save(user);
            return new ResponseEntity<>(userSaved, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<User> deleteUser(long userId) {
        try {
            userModelDAO.deleteById(userId);
            return new ResponseEntity("User deleted: " + userId, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("User not found" + e, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<User> editUser(User user, long userId) {

        User userInDB = userModelDAO.findById(userId).get();

        if (Objects.nonNull(user.getEmail()))
            userInDB.setEmail(user.getEmail());

        if (Objects.nonNull(user.getOtherParentId()))
            userInDB.setOtherParentId(user.getOtherParentId());

        return new ResponseEntity<>(userModelDAO.save(userInDB), HttpStatus.OK);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userModelDAO.loadUserByUsername(username);
    }
}



