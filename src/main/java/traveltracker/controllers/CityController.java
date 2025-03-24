package traveltracker.controllers;

import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import traveltracker.entities.City;
import traveltracker.repositories.CityRepository;
import traveltracker.services.CityService;

import java.util.Optional;

@RestController
@RequestMapping("/cities")
public class CityController {
    private final CityService cityService;
    private final CityRepository cityRepository;

    @Autowired
    public CityController(CityService cityService, CityRepository cityRepository) {
        this.cityService = cityService;
        this.cityRepository = cityRepository;
    }

    @GetMapping("/{id}")
    public Optional<City> getCityById(@PathVariable Integer id) {
        return cityService.getCityById(id);
    }

    /*@PostMapping("/add")
    public String addCities(@RequestParam String playersWithCommas) { //List<Player> players
        String[] players = playersWithCommas.split(",");
        for (String player : players) {
            playerList.add(player);
        }
        return "all good, every Player was added";
    }*/
    @PostMapping("/add")
    public City addCity(@RequestBody City city) {
        return cityService.addCity(city);
    }

    @PutMapping("/update-city-{cityId}")
    public ResponseEntity<City> updateCity(
            @PathVariable Integer cityId,
            @RequestBody City cityDetails) {

        City updatedEntity = cityService.updateCity(cityId, cityDetails);
        return ResponseEntity.ok(updatedEntity);
    }
}
