package traveltracker.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import traveltracker.entities.TripDetail;
import traveltracker.repositories.TripDetailRepository;
import traveltracker.services.TripDetailService;

@RestController
@RequestMapping("/trip-details")
public class TripDetailController {
    private final TripDetailService tripDetailService;
    private final TripDetailRepository tripDetailRepository;

    @Autowired
    public TripDetailController(TripDetailService tripDetailService, TripDetailRepository tripDetailRepository) {
        this.tripDetailService = tripDetailService;
        this.tripDetailRepository = tripDetailRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TripDetail> getRoutesByTripId(@PathVariable Integer id) {
        return ResponseEntity.ok(tripDetailService.getRoutesByTripId(id));
    }

    @PostMapping("/add")
    public ResponseEntity<TripDetail> addTripDetail(@Valid @RequestBody TripDetail tripDetail) {
        return ResponseEntity.ok(tripDetailService.addTripDetail(tripDetail));
    }

    @PutMapping("/update-{tripDetailId}")
    public ResponseEntity<TripDetail> updateTripDetail(
            @PathVariable Integer tripDetailId,
            @Valid @RequestBody TripDetail tripDetailDetails) {

        TripDetail updatedEntity = tripDetailService.updateTripDetail(tripDetailId, tripDetailDetails);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/delete-{tripDetailId}")
    public ResponseEntity<TripDetail> deleteTripDetail(@PathVariable Integer tripDetailId) {
        tripDetailService.deleteTripDetail(tripDetailId);
        return ResponseEntity.noContent().build();
    }
}
