package traveltracker.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import traveltracker.entities.Trip;
import traveltracker.repositories.TripRepository;
import traveltracker.services.*;

import java.util.List;

@RestController
@RequestMapping("/trips")
public class TripController {
    private final TripService tripService;
    private final TripRepository tripRepository;

    @Autowired
    public TripController(TripService tripService, TripRepository tripRepository) {
        this.tripService = tripService;
        this.tripRepository = tripRepository;
    }

    @GetMapping ("/all-trips")
    public List<Trip> getAllTrips() {
        return tripService.getAllTrips();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trip> getTripById(@PathVariable Integer id) {
        return ResponseEntity.ok(tripService.getTripById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Trip> addTrip(@Valid @RequestBody Trip trip) {
        return ResponseEntity.ok(tripService.addTrip(trip));
    }

    @PutMapping("/update-{tripId}")
    public ResponseEntity<Trip> updateTrip(
            @PathVariable Integer tripId,
            @Valid @RequestBody Trip tripDetails) {

        Trip updatedEntity = tripService.updateTrip(tripId, tripDetails);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/delete-{tripId}")
    public ResponseEntity<Trip> deleteTrip(@PathVariable Integer tripId) {
        tripService.deleteTrip(tripId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/emissions/{tripId}")
    public ResponseEntity<String> calculateTripEmissions(@PathVariable Integer tripId) {
        return ResponseEntity.ok(tripService.sendTripEmissions(tripId));
    }

}