package traveltracker.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import traveltracker.ResourceNotFoundException;
import traveltracker.entities.City;
import traveltracker.repositories.CityRepository;


@Service
public class CityService {
    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public City getCityById(Integer id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("City not found with id: " + id));
    }

    public City addCity(City city) {
        return cityRepository.save(city);
    }

    public City updateCity(Integer cityId, City cityDetails) {
        City existingCity = cityRepository.findById(cityId)
                .orElseThrow(() -> new ResourceNotFoundException("City not found with id: " + cityId));

        existingCity.setCityName(cityDetails.getCityName());
        existingCity.setCountry(cityDetails.getCountry());

        return cityRepository.save(existingCity);
    }

    @Transactional
    public void deleteCity(Integer cityId) {
        cityRepository.findById(cityId)
                .orElseThrow(() -> new ResourceNotFoundException("City not found with id: " + cityId));
        cityRepository.deleteById(cityId);
    }
}
