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


    //TODO: Not working in postman when Pre- or PostAuthorize or RolesAllowed is in use. error 500
    @GetMapping("api/getUser/{username}")
    // @PreAuthorize("hasRole('ADMIN') and #username == authentication.name")
    //@PostAuthorize("returnObject.username == 'Kattis'")
    //@RolesAllowed({"ADMIN", "USER"})
    private User getUserByUsername(@PathVariable("username") String username) {
        return userService.loadUserByUsername(username);
    }


    @PostMapping("/api/saveUser")
    private void saveUser(@RequestBody UserRequest userRequest) {
         authService.createUser(userRequest);
    }

    @DeleteMapping("/api/deleteUserById/{userId}")
    private ResponseEntity<User> deleteUser(@PathVariable("userId") long userId) {
        return userService.deleteUser(userId);
    }

    @PatchMapping("/api/editUser/{userId}")
    private ResponseEntity<User> editUser(@RequestBody User user, @PathVariable("userId") long userId) {
        return userService.editUser(user, userId);
    }


}
