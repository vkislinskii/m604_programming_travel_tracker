package traveltracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import traveltracker.entities.City;
import traveltracker.entities.Interest;
import traveltracker.repositories.InterestRepository;
import traveltracker.services.InterestService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/interests")
public class InterestController {
    private final InterestService interestService;
    private final InterestRepository interestRepository;

    @Autowired
    public InterestController(InterestService interestService, InterestRepository interestRepository) {

        this.interestService = interestService;
        this.interestRepository = interestRepository;
    }

    @GetMapping("/all")
    public List<Interest> getAllInterests() {
        return interestService.getAllInterests();
    }

    @PostMapping("/add")
    public Interest addInterest(@RequestBody Interest interest) {
        return interestService.addInterest(interest);
    }
}
