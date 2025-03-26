package traveltracker.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import traveltracker.entities.CityInterest;
import traveltracker.services.CityInterestService;

import java.util.List;

@RestController
@RequestMapping("/api/cities-interests")
public class CityInterestController {
    private final CityInterestService cityInterestService;

    @Autowired
    public CityInterestController(CityInterestService cityInterestService) {
        this.cityInterestService = cityInterestService;
    }

    @GetMapping("/interests/{cityId}")
    public ResponseEntity<List<CityInterest>> getInterestByCityId(@PathVariable Integer cityId) {
        return ResponseEntity.ok(cityInterestService.getInterestByCityId(cityId));
    }

    @PostMapping("/add")
    public ResponseEntity<CityInterest> addCityInterest(@Valid @RequestBody CityInterest cityInterest) {
        return ResponseEntity.ok(cityInterestService.addCityInterest(cityInterest));
    }

    @DeleteMapping("/{cityId}/{interestId}")
    public ResponseEntity<CityInterest> deleteCityInterest(@PathVariable Integer cityId, @PathVariable Integer interestId) {
        cityInterestService.deleteCityInterest(cityId, interestId);
        return ResponseEntity.noContent().build();
    }

}
