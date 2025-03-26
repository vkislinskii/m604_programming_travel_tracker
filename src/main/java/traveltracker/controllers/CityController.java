package traveltracker.controllers;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import traveltracker.entities.City;
import traveltracker.services.CityService;

@RestController
@RequestMapping("/api/cities")
public class CityController {
    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/{cityId}")
    public ResponseEntity<City> getCityById(@PathVariable Integer cityId) {
        return ResponseEntity.ok(cityService.getCityById(cityId));
    }

    @PostMapping("/add")
    public ResponseEntity<City> addCity(@Valid @RequestBody City city) {
        return ResponseEntity.ok(cityService.addCity(city));
    }

    @PutMapping("/{cityId}")
    public ResponseEntity<City> updateCity(
            @PathVariable Integer cityId,
            @Valid @RequestBody City cityDetails) {

        City updatedEntity = cityService.updateCity(cityId, cityDetails);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/{cityId}")
    public ResponseEntity<City> deleteCity(@PathVariable Integer cityId) {
        cityService.deleteCity(cityId);
        return ResponseEntity.noContent().build();
    }
}
