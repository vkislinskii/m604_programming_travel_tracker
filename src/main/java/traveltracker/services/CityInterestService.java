package traveltracker.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import traveltracker.entities.CityInterest;
import traveltracker.entities.CityInterestId;
import traveltracker.repositories.CityInterestRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CityInterestService {
    private final CityInterestRepository cityInterestRepository;

    @Autowired
    public CityInterestService(CityInterestRepository cityInterestRepository) {
        this.cityInterestRepository = cityInterestRepository;
    }

    public List<CityInterest> getInterestByCityId(Integer id) {
        return cityInterestRepository.findByCity_CityId(id);
    }

    public CityInterest addCityInterest(CityInterest cityInterest) {
        return cityInterestRepository.save(cityInterest);
    }

    @Transactional
    public boolean deleteCityInterest(Integer cityId, Integer interestId) {
        CityInterestId id = new CityInterestId();
        id.setCityId(cityId);
        id.setInterestId(interestId);
        if (cityInterestRepository.existsById(id)) {
            cityInterestRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
