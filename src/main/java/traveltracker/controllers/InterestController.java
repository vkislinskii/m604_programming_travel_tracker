package traveltracker.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import traveltracker.entities.Interest;
import traveltracker.services.InterestService;

import java.util.List;

@RestController
@RequestMapping("/api/interests")
public class InterestController {
    private final InterestService interestService;

    @Autowired
    public InterestController(InterestService interestService) {

        this.interestService = interestService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Interest>> getAllInterests() {
        return ResponseEntity.ok(interestService.getAllInterests());
    }

    @PostMapping("/add")
    public ResponseEntity<Interest> addInterest(@Valid @RequestBody Interest interest) {
        return ResponseEntity.ok(interestService.addInterest(interest));
    }

    @PutMapping("/{interestId}")
    public ResponseEntity<Interest> updateInterest(
            @PathVariable Integer interestId,
            @Valid @RequestBody Interest interestDetails) {

        Interest updatedEntity = interestService.updateInterest(interestId, interestDetails);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/{interestId}")
    public ResponseEntity<Interest> deleteInterest(@PathVariable Integer interestId) {
        interestService.deleteInterest(interestId);
        return ResponseEntity.noContent().build();
    }
}
