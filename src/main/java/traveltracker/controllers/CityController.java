package traveltracker.controllers;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import traveltracker.entities.City;
import traveltracker.repositories.CityRepository;
import traveltracker.services.CityService;

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
    public ResponseEntity<City> getCityById(@PathVariable Integer id) {
        return ResponseEntity.ok(cityService.getCityById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<City> addCity(@Valid @RequestBody City city) {
        return ResponseEntity.ok(cityService.addCity(city));
    }

    @PutMapping("/update-city-{cityId}")
    public ResponseEntity<City> updateCity(
            @PathVariable Integer cityId,
            @Valid @RequestBody City cityDetails) {

        City updatedEntity = cityService.updateCity(cityId, cityDetails);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/delete-{cityId}")
    public ResponseEntity<City> deleteCity(@PathVariable Integer cityId) {
        cityService.deleteCity(cityId);
        return ResponseEntity.noContent().build();
    }
}
