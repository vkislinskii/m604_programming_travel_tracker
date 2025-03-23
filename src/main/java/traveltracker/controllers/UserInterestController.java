package traveltracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import traveltracker.entities.CityInterest;
import traveltracker.entities.UserInterest;
import traveltracker.services.UserInterestService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user-interests")
public class UserInterestController {
    private final UserInterestService userInterestService;

    @Autowired
    public UserInterestController(UserInterestService userInterestService) {
        this.userInterestService = userInterestService;
    }

    @GetMapping("/interests-user{id}")
    public List<UserInterest> getInterestByUserId(@PathVariable Integer id) {
        return userInterestService.getInterestByUserId(id);
    }
}
