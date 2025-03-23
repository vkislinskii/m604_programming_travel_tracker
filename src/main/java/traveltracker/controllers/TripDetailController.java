package traveltracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import traveltracker.entities.TripDetail;
import traveltracker.services.TripDetailService;

import java.util.Optional;

@RestController
@RequestMapping("/trip-details")
public class TripDetailController {
    private final TripDetailService tripDetailService;

    @Autowired
    public TripDetailController(TripDetailService tripDetailService) {
        this.tripDetailService = tripDetailService;
    }

    @GetMapping("/{id}")
    public Optional<TripDetail> getRoutesByTripId(@PathVariable Integer id) {
        return tripDetailService.getRoutesByTripId(id);
    }
}
