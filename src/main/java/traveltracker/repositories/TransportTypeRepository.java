package traveltracker.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import traveltracker.entities.TransportType;

public interface TransportTypeRepository extends JpaRepository<TransportType, String>{
}
