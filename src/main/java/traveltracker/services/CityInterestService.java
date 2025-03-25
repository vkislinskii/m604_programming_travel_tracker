package traveltracker.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import traveltracker.ResourceNotFoundException;
import traveltracker.entities.CityInterest;
import traveltracker.entities.CityInterestId;
import traveltracker.repositories.CityInterestRepository;

import java.util.List;

@Service
public class CityInterestService {
    private final CityInterestRepository cityInterestRepository;

    @Autowired
    public CityInterestService(CityInterestRepository cityInterestRepository) {
        this.cityInterestRepository = cityInterestRepository;
    }

    public List<CityInterest> getInterestByCityId(Integer id) {
        List<CityInterest> interests = cityInterestRepository.findByCity_CityId(id);
        if (interests.isEmpty()) {
            throw new ResourceNotFoundException("No interests found for city ID: " + id);
        }
        return interests;
    }

    public CityInterest addCityInterest(CityInterest cityInterest) {
        return cityInterestRepository.save(cityInterest);
    }

    @Transactional
    public void deleteCityInterest(Integer cityId, Integer interestId) {
        CityInterestId id = new CityInterestId();
        id.setCityId(cityId);
        id.setInterestId(interestId);
        cityInterestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("City Interest not found with composite id: " + id));
        cityInterestRepository.deleteById(id);
    }
}
