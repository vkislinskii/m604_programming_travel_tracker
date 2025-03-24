package traveltracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import traveltracker.entities.Station;
import traveltracker.repositories.StationRepository;
import traveltracker.services.StationService;

import java.util.List;
import java.util.Optional;

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
    public List<Station> getAllStations() {
        return stationService.getAllStations();
    }

    @PostMapping("/add")
    public Station addStation(@RequestBody Station station) {
        return stationService.addStation(station);
    }

    @PutMapping("/update-{stationName}")
    public ResponseEntity<Station> updateStation(
            @PathVariable String stationName,
            @RequestBody Station stationDetails) {

        Station updatedEntity = stationService.updateStation(stationName, stationDetails);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/delete-{stationName}")
    public ResponseEntity<Void> deleteStation(@PathVariable String stationName) {
        boolean isDeleted = stationService.deleteStation(stationName);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
