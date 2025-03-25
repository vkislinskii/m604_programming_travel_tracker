package traveltracker.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import traveltracker.entities.CityInterest;
import traveltracker.repositories.CityInterestRepository;
import traveltracker.services.CityInterestService;

import java.util.List;

@RestController
@RequestMapping("/cities-interests")
public class CityInterestController {
    private final CityInterestService cityInterestService;
    private final CityInterestRepository cityInterestRepository;

    @Autowired
    public CityInterestController(CityInterestService cityInterestService, CityInterestRepository cityInterestRepository) {
        this.cityInterestService = cityInterestService;
        this.cityInterestRepository = cityInterestRepository;
    }

    @GetMapping("/interests-city{id}")
    public ResponseEntity<List<CityInterest>> getInterestByCityId(@PathVariable Integer id) {
        return ResponseEntity.ok(cityInterestService.getInterestByCityId(id));
    }

    @PostMapping("/add")
    public ResponseEntity<CityInterest> addCityInterest(@Valid @RequestBody CityInterest cityInterest) {
        return ResponseEntity.ok(cityInterestService.addCityInterest(cityInterest));
    }

    @DeleteMapping("/delete-{cityId}-{interestId}")
    public ResponseEntity<CityInterest> deleteCityInterest(@PathVariable Integer cityId, @PathVariable Integer interestId) {
        cityInterestService.deleteCityInterest(cityId, interestId);
        return ResponseEntity.noContent().build();
    }

}
