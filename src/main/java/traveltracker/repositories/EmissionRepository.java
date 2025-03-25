package traveltracker.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import traveltracker.entities.Emission;
import traveltracker.entities.TransportType;

public interface EmissionRepository extends JpaRepository<Emission, Integer>{
    Emission findByTransportType_TransportType(String transportType);
}
