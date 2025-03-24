package traveltracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import traveltracker.entities.Route;
import traveltracker.entities.TripDetail;
import traveltracker.repositories.TripDetailRepository;
import traveltracker.services.TripDetailService;

import java.util.Optional;

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
    public Optional<TripDetail> getRoutesByTripId(@PathVariable Integer id) {
        return tripDetailService.getRoutesByTripId(id);
    }

    @PostMapping("/add")
    public TripDetail addTripDetail(@RequestBody TripDetail tripDetail) {
        return tripDetailService.addTripDetail(tripDetail);
    }

    @PutMapping("/update-{tripDetailId}")
    public ResponseEntity<TripDetail> updateTripDetail(
            @PathVariable Integer tripDetailId,
            @RequestBody TripDetail tripDetailDetails) {

        TripDetail updatedEntity = tripDetailService.updateTripDetail(tripDetailId, tripDetailDetails);
        return ResponseEntity.ok(updatedEntity);
    }
}
