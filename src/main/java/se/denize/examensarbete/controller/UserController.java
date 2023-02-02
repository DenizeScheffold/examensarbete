package se.denize.examensarbete.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import se.denize.examensarbete.model.User;
import se.denize.examensarbete.serviceImpl.UserServiceImpl;

import java.util.List;

@RestController
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


   //TODO: Not working in postman when Pre- or PostAuthorize or RolesAllowed is in use. error 500
    @GetMapping("api/getUser/{username}")
   // @PreAuthorize("hasRole('ADMIN') and #username == authentication.name")
    //@PostAuthorize("returnObject.username == 'Kattis'")
    //@RolesAllowed({"ADMIN", "USER"})
    private User getUserByUsername(@PathVariable("username") String username)
    {return userService.loadUserByUsername(username);}


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
