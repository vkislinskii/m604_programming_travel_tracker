package traveltracker.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import traveltracker.entities.UserInterest;
import traveltracker.services.UserInterestService;

import java.util.List;

@RestController
@RequestMapping("/api/user-interests")
public class UserInterestController {
    private final UserInterestService userInterestService;

    @Autowired
    public UserInterestController(UserInterestService userInterestService) {
        this.userInterestService = userInterestService;
    }

    @GetMapping("/interests/{userId}")
    public ResponseEntity<List<UserInterest>> getInterestByUserId(@PathVariable Integer userId) {
        return ResponseEntity.ok(userInterestService.getInterestByUserId(userId));
    }

    @PostMapping("/add")
    public ResponseEntity<UserInterest> addUserInterest(@Valid @RequestBody UserInterest userInterest) {
        return ResponseEntity.ok(userInterestService.addUserInterest(userInterest));
    }

    @DeleteMapping("/{userId}/{interestId}")
    public ResponseEntity<UserInterest> deleteUserInterest(@PathVariable Integer userId, @PathVariable Integer interestId) {
        userInterestService.deleteUserInterest(userId, interestId);
        return ResponseEntity.noContent().build();
    }
}
