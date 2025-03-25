package traveltracker.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import traveltracker.entities.Station;
import traveltracker.repositories.StationRepository;
import traveltracker.services.StationService;

import java.util.List;

@RestController
@RequestMapping("/stations")
public class StationController {
    private final StationService stationService;
    private final StationRepository stationRepository;

    @Autowired
    public StationController(StationService stationService, StationRepository stationRepository) {
        this.stationService = stationService;
        this.stationRepository = stationRepository;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Station>> getAllStations() {
        return ResponseEntity.ok(stationService.getAllStations());
    }

    @PostMapping("/add")
    public ResponseEntity<Station> addStation(@Valid @RequestBody Station station) {
        return ResponseEntity.ok(stationService.addStation(station));
    }

    @PutMapping("/update-{stationName}")
    public ResponseEntity<Station> updateStation(
            @PathVariable String stationName,
            @Valid @RequestBody Station stationDetails) {

        Station updatedEntity = stationService.updateStation(stationName, stationDetails);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/delete-{stationName}")
    public ResponseEntity<Station> deleteStation(@PathVariable String stationName) {
        stationService.deleteStation(stationName);
        return ResponseEntity.noContent().build();
    }
}
