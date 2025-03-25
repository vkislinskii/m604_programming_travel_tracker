package traveltracker.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import traveltracker.entities.Station;


public interface StationRepository extends JpaRepository<Station, String>{

}
