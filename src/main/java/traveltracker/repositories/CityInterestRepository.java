package traveltracker.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import traveltracker.entities.CityInterest;
import traveltracker.entities.CityInterestId;

import java.util.List;
import java.util.Optional;

public interface CityInterestRepository extends JpaRepository<CityInterest, CityInterestId>{
    List<CityInterest> findByCity_CityId(Integer cityCityId);
}
