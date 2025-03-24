package traveltracker.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

        existingCity.setCityName(cityDetails.getCityName());
        existingCity.setCountry(cityDetails.getCountry());

        return cityRepository.save(existingCity);
    }

    @Transactional
    public boolean deleteCity(Integer cityId) {
        if (cityRepository.existsById(cityId)) {
            cityRepository.deleteById(cityId);
            return true;
        }
        return false;
    }
}
