package traveltracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import traveltracker.entities.City;
import traveltracker.entities.CityInterest;
import traveltracker.entities.CityInterestId;
import traveltracker.repositories.CityInterestRepository;
import traveltracker.repositories.CityRepository;
import traveltracker.services.CityInterestService;

import java.util.List;
import java.util.Optional;

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
    public List<CityInterest> getInterestByCityId(@PathVariable Integer id) {
        return cityInterestService.getInterestByCityId(id);
    }

    @PostMapping("/add")
    public CityInterest addCityInterest(@RequestBody CityInterest cityInterest) {
        return cityInterestService.addCityInterest(cityInterest);
    }


}
