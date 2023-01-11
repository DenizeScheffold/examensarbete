package se.denize.examensarbete.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import se.denize.examensarbete.model.User;
import se.denize.examensarbete.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<List<User>> getAllUsers() {
        List<User> employees = new ArrayList<>(userRepository.findAll());
        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    //TODO check if user already exists
    public ResponseEntity<User> saveUser(@RequestBody User user){
        try {
            User userSaved = userRepository.save(user);
            return new ResponseEntity<>(userSaved, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<User> deleteUser(long userId){
        try{
            userRepository.deleteById(userId);
            return new ResponseEntity("User deleted: " + userId, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity("User not found" + e, HttpStatus.NOT_FOUND);
        }
    }



}
