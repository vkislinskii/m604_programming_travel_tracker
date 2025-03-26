package traveltracker.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import traveltracker.entities.TripDetail;
import traveltracker.services.TripDetailService;

@RestController
@RequestMapping("/api/trip-details")
public class TripDetailController {
    private final TripDetailService tripDetailService;

    @Autowired
    public TripDetailController(TripDetailService tripDetailService) {
        this.tripDetailService = tripDetailService;
    }

    @GetMapping("/{tripDetailId}")
    public ResponseEntity<TripDetail> getRoutesByTripId(@PathVariable Integer tripDetailId) {
        return ResponseEntity.ok(tripDetailService.getRoutesByTripId(tripDetailId));
    }

    @PostMapping("/add")
    public ResponseEntity<TripDetail> addTripDetail(@Valid @RequestBody TripDetail tripDetail) {
        return ResponseEntity.ok(tripDetailService.addTripDetail(tripDetail));
    }

    @PutMapping("/{tripDetailId}")
    public ResponseEntity<TripDetail> updateTripDetail(
            @PathVariable Integer tripDetailId,
            @Valid @RequestBody TripDetail tripDetailDetails) {

        TripDetail updatedEntity = tripDetailService.updateTripDetail(tripDetailId, tripDetailDetails);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/{tripDetailId}")
    public ResponseEntity<TripDetail> deleteTripDetail(@PathVariable Integer tripDetailId) {
        tripDetailService.deleteTripDetail(tripDetailId);
        return ResponseEntity.noContent().build();
    }
}
