package traveltracker.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import traveltracker.entities.City;
import traveltracker.entities.Station;

import java.util.Optional;

public interface StationRepository extends JpaRepository<Station, String>{

    Optional<Station> findByCity(City city);
}
