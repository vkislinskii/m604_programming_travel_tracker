package traveltracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import traveltracker.entities.User;
import traveltracker.repositories.UserRepository;
import traveltracker.services.UserService;

import java.util.Optional;

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
    public Optional<User> getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping("/update-{userId}")
    public ResponseEntity<User> updateUser(
            @PathVariable Integer userId,
            @RequestBody User userDetails) {

        User updatedEntity = userService.updateUser(userId, userDetails);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/delete-{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer userId) {
        boolean isDeleted = userService.deleteUser(userId);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/emissions/{userId}")
    public String calculateUserLastTripEmission(@PathVariable Integer userId) {
        return userService.calculateUserLastTripEmission(userId);
    }
}
