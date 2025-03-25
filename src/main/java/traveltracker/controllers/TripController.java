package traveltracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import traveltracker.entities.Trip;
import traveltracker.repositories.TripRepository;
import traveltracker.services.*;

import java.util.List;
import java.util.Optional;

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
        return tripService.getAllTrips(); //getTripsByTripId
    }

    @GetMapping("/{id}")
    public Optional<Trip> getTripById(@PathVariable Integer id) {
        return tripService.getTripById(id);
    }

    @PostMapping("/add")
    public Trip addTrip(@RequestBody Trip trip) {
        return tripService.addTrip(trip);
    }

    @PutMapping("/update-{tripId}")
    public ResponseEntity<Trip> updateTrip(
            @PathVariable Integer tripId,
            @RequestBody Trip tripDetails) {

        Trip updatedEntity = tripService.updateTrip(tripId, tripDetails);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/delete-{tripId}")
    public ResponseEntity<Void> deleteTrip(@PathVariable Integer tripId) {
        boolean isDeleted = tripService.deleteTrip(tripId);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/emissions/{tripId}")
    public String calculateTripEmissions(@PathVariable Integer tripId) {
        return tripService.sendTripEmissions(tripId);
    }

    /*@GetMapping("/{tripId}/emissions")
    public ResponseEntity<Double> getTripEmissions(@PathVariable int tripId) {
        double emissions = tripService.calculateTripEmissions(tripId);
        return new ResponseEntity<>(emissions, HttpStatus.OK);
    }*/

    /*@PostMapping
    public <TripRequest> ResponseEntity<Trip> createTrip(
            @RequestBody TripRequest tripRequest // DTO class to accept user input
    ) {
        Trip trip = new Trip();
        // Map fields from tripRequest to trip (e.g., cityDepartureId, user_id)
        Trip createdTrip = tripService.createTrip(trip, tripRequest.getRouteIds());
        return new ResponseEntity<>(createdTrip, HttpStatus.CREATED);
    }*/

}