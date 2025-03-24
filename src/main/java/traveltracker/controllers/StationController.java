package traveltracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import traveltracker.entities.Route;
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
}
