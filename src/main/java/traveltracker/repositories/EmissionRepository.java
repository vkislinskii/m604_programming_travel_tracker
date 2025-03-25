package traveltracker.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import traveltracker.entities.Emission;

public interface EmissionRepository extends JpaRepository<Emission, Integer>{
    Emission findByTransportType_TransportType(String transportType);
}
