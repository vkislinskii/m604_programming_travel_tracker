package traveltracker.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import traveltracker.entities.UserInterest;
import traveltracker.repositories.UserInterestRepository;
import traveltracker.services.UserInterestService;

import java.util.List;

@RestController
@RequestMapping("/user-interests")
public class UserInterestController {
    private final UserInterestService userInterestService;
    private final UserInterestRepository userInterestRepository;

    @Autowired
    public UserInterestController(UserInterestService userInterestService, UserInterestRepository userInterestRepository) {
        this.userInterestService = userInterestService;
        this.userInterestRepository = userInterestRepository;
    }

    @GetMapping("/interests-user{id}")
    public ResponseEntity<List<UserInterest>> getInterestByUserId(@PathVariable Integer id) {
        return ResponseEntity.ok(userInterestService.getInterestByUserId(id));
    }

    @PostMapping("/add")
    public ResponseEntity<UserInterest> addUserInterest(@Valid @RequestBody UserInterest userInterest) {
        return ResponseEntity.ok(userInterestService.addUserInterest(userInterest));
    }

    @DeleteMapping("/delete-{userId}-{interestId}")
    public ResponseEntity<UserInterest> deleteUserInterest(@PathVariable Integer userId, @PathVariable Integer interestId) {
        userInterestService.deleteUserInterest(userId, interestId);
        return ResponseEntity.noContent().build();
    }
}
