package traveltracker.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import traveltracker.entities.CityInterest;
import traveltracker.entities.CityInterestId;

import java.util.List;

public interface CityInterestRepository extends JpaRepository<CityInterest, CityInterestId>{
    List<CityInterest> findByCity_CityId(Integer cityCityId);
}
