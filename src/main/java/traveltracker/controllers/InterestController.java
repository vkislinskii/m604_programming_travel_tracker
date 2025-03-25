package traveltracker.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import traveltracker.entities.Interest;
import traveltracker.repositories.InterestRepository;
import traveltracker.services.InterestService;

import java.util.List;

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
    public ResponseEntity<List<Interest>> getAllInterests() {
        return ResponseEntity.ok(interestService.getAllInterests());
    }

    @PostMapping("/add")
    public ResponseEntity<Interest> addInterest(@Valid @RequestBody Interest interest) {
        return ResponseEntity.ok(interestService.addInterest(interest));
    }

    @PutMapping("/update-{interestId}")
    public ResponseEntity<Interest> updateInterest(
            @PathVariable Integer interestId,
            @Valid @RequestBody Interest interestDetails) {

        Interest updatedEntity = interestService.updateInterest(interestId, interestDetails);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/delete-{interestId}")
    public ResponseEntity<Interest> deleteInterest(@PathVariable Integer interestId) {
        interestService.deleteInterest(interestId);
        return ResponseEntity.noContent().build();
    }
}
