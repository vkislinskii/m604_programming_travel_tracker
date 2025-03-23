package traveltracker.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import traveltracker.entities.CityInterest;

import java.util.List;
import java.util.Optional;

public interface CityInterestRepository extends JpaRepository<CityInterest, Integer>{
    List<CityInterest> findByCity_CityId(Integer cityCityId);
}
