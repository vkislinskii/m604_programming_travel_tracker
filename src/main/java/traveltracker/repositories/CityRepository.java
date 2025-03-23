package traveltracker.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import traveltracker.entities.City;

public interface CityRepository extends JpaRepository<City, Integer>{
}
