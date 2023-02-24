package se.denize.examensarbete.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.denize.examensarbete.model.User;
import se.denize.examensarbete.repository.UserRepository;
import se.denize.examensarbete.request.UserRequest;
import se.denize.examensarbete.service.AuthService;
import se.denize.examensarbete.serviceImpl.UserServiceImpl;

import java.util.List;

@RestController
public class UserController {

    private final UserServiceImpl userService;
    private final AuthService authService;

    @Autowired
    public UserController(UserServiceImpl userService, AuthService authService) {
        this.userService = userService;
        this.authService = authService;
    }

    @GetMapping("/api/getUsers")
    private ResponseEntity<List<User>> getAllUsers() {
        return userService.getAllUsers();
    }


    @GetMapping("api/getUser")
    private User getUserByUsername() {
        return userService.loadUserByUsername(userService.findCurrentUserFromToken().getUsername());
    }


    @PostMapping("/api/saveUser")
    private void saveUser(@RequestBody UserRequest userRequest) {
        authService.createUser(userRequest);
    }

    //TODO: test
    @DeleteMapping("/api/deleteUserById")
    private ResponseEntity<User> deleteUser() {
        return userService.deleteUser(userService.findCurrentUserIdFromToken());
    }

    @PatchMapping("/api/editUser")
    private ResponseEntity<User> editUser(@RequestBody User user) {
        return userService.editUser(user, userService.findCurrentUserIdFromToken() );
    }


}
