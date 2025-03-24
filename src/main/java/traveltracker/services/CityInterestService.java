package traveltracker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import traveltracker.entities.City;
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
}
