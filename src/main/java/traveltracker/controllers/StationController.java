package traveltracker.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import traveltracker.entities.Station;
import traveltracker.services.StationService;

import java.util.List;

@RestController
@RequestMapping("/api/stations")
public class StationController {
    private final StationService stationService;

    @Autowired
    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Station>> getAllStations() {
        return ResponseEntity.ok(stationService.getAllStations());
    }

    @PostMapping("/add")
    public ResponseEntity<Station> addStation(@Valid @RequestBody Station station) {
        return ResponseEntity.ok(stationService.addStation(station));
    }

    @PutMapping("/{stationName}")
    public ResponseEntity<Station> updateStation(
            @PathVariable String stationName,
            @Valid @RequestBody Station stationDetails) {

        Station updatedEntity = stationService.updateStation(stationName, stationDetails);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/{stationName}")
    public ResponseEntity<Station> deleteStation(@PathVariable String stationName) {
        stationService.deleteStation(stationName);
        return ResponseEntity.noContent().build();
    }
}
