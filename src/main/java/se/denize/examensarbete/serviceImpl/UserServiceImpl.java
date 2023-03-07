package se.denize.examensarbete.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import se.denize.examensarbete.dataObjects.UserDAO;
import se.denize.examensarbete.model.User;
import se.denize.examensarbete.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserDAO userDao;

    @Autowired
    public UserServiceImpl(UserDAO userDao) {
        this.userDao = userDao;
    }

    @Override
    public Long findCurrentUserIdFromToken() throws UsernameNotFoundException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();

            return userDao.loadUserByUsername(currentUserName).getUserId();
        }
        return null;
    }

    @Override
    public User findCurrentUserFromToken() throws UsernameNotFoundException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {

            return loadUserByUsername(authentication.getName());
        }
        return null;
    }

    @Override
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = new ArrayList<>(userDao.findAllUsers());
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
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

    public User findOtherParent(long userId){
        return userDao.findOtherParent(userId);
    }

    public Optional<User> findUserById(long userId){
        return userDao.findById(userId);
    }



}



