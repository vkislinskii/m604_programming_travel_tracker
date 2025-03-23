package traveltracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import traveltracker.entities.Interest;
import traveltracker.services.InterestService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/interests")
public class InterestController {
    private final InterestService interestService;

    @Autowired
    public InterestController(InterestService interestService) {
        this.interestService = interestService;
    }

    @GetMapping("/all")
    public List<Interest> getAllInterests() {
        return interestService.getAllInterests();
    }
}
