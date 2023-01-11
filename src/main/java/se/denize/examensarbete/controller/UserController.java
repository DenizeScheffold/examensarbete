package se.denize.examensarbete.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import se.denize.examensarbete.model.User;
import se.denize.examensarbete.serviceImpl.UserServiceImpl;

import java.util.List;

@Controller
public class UserController {

    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/api/getUsers")
    private ResponseEntity<List<User>> getAllUsers(){
    return userService.getAllUsers();
   }

   @PostMapping("/api/saveUser")
    private ResponseEntity<User> saveUser(@RequestBody final User user){
        return userService.saveUser(user);
   }

   @DeleteMapping("/api/deleteUserById/{id}")
    private ResponseEntity<User> deleteUser(@PathVariable("id") long userId){
        return userService.deleteUser(userId);
   }



   /*
    @GetMapping("/api/weekPage")
    public String getWeek(Model model){
        model.addAttribute("week",userRepository.findAll());
        return "weekPage";
    }


    @GetMapping("/ws/user")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/ws/addUser")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        return new ResponseEntity<>(userRepository.save(user), HttpStatus.OK);
    }
     */

}
