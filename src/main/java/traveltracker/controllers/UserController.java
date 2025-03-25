package traveltracker.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import traveltracker.entities.User;
import traveltracker.repositories.UserRepository;
import traveltracker.services.UserService;


@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
        return ResponseEntity.ok(userService.addUser(user));
    }

    @PutMapping("/update-{userId}")
    public ResponseEntity<User> updateUser(
            @PathVariable Integer userId,
            @Valid @RequestBody User userDetails) {

        User updatedEntity = userService.updateUser(userId, userDetails);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/delete-{userId}")
    public ResponseEntity<User> deleteUser(@PathVariable Integer userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/emissions/{userId}")
    public ResponseEntity<String> calculateUserLastTripEmission(@PathVariable Integer userId) {
        return ResponseEntity.ok(userService.calculateUserLastTripEmission(userId));
    }
}
