package traveltracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import traveltracker.entities.CityInterest;
import traveltracker.services.CityInterestService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cities-interests")
public class CityInterestController {
    private final CityInterestService cityInterestService;

    @Autowired
    public CityInterestController(CityInterestService cityInterestService) {
        this.cityInterestService = cityInterestService;
    }

    @GetMapping("/interests-city{id}")
    public List<CityInterest> getInterestByCityId(@PathVariable Integer id) {
        return cityInterestService.getInterestByCityId(id);
    }
}
