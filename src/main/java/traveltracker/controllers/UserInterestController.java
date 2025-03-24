package traveltracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import traveltracker.entities.UserInterest;
import traveltracker.repositories.UserInterestRepository;
import traveltracker.services.UserInterestService;

import java.util.List;
import java.util.Optional;

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
    public List<UserInterest> getInterestByUserId(@PathVariable Integer id) {
        return userInterestService.getInterestByUserId(id);
    }

    @PostMapping("/add")
    public UserInterest addUserInterest(@RequestBody UserInterest userInterest) {
        return userInterestService.addUserInterest(userInterest);
    }

    @DeleteMapping("/delete-{userId}-{interestId}")
    public ResponseEntity<Void> deleteUserInterest(@PathVariable Integer userId, @PathVariable Integer interestId) {
        boolean isDeleted = userInterestService.deleteUserInterest(userId, interestId);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
