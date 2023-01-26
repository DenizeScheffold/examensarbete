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

   @DeleteMapping("/api/deleteUserById/{userId}")
    private ResponseEntity<User> deleteUser(@PathVariable("userId") long userId){
        return userService.deleteUser(userId);
   }

   @PatchMapping("/api/editUser/{userId}")
    private ResponseEntity<User> editUser(@RequestBody User user, @PathVariable("userId")long userId){
        return userService.editUser(user,userId);
   }

}
