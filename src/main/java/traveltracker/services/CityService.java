package traveltracker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import traveltracker.entities.City;
import traveltracker.repositories.CityRepository;

import java.util.Optional;

@Service
public class CityService {
    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public Optional<City> getCityById(Integer id) {
        return cityRepository.findById(id);
    }

    public City addCity(City city) {
        return cityRepository.save(city);
    }

    public City updateCity(Integer cityId, City cityDetails) {
        City existingCity = cityRepository.findById(cityId)
                .orElseThrow(() -> new RuntimeException("Entity not found with id: " + cityId));

        // Update all fields you want to be updatable
        existingCity.setCityName(cityDetails.getCityName());
        existingCity.setCountry(cityDetails.getCountry());
        // ... update other fields as needed

        return cityRepository.save(existingCity);
    }
}
