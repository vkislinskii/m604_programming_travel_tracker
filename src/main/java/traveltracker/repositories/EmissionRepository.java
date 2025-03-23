package traveltracker.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import traveltracker.entities.Emission;

public interface EmissionRepository extends JpaRepository<Emission, Integer>{
    @Query("SELECT e FROM Emission e " +
            "WHERE e.transportType = :transportType " +
            "AND :distance BETWEEN e.minDistance AND e.maxDistance")
    Emission findByTransportTypeAndDistance(
            @Param("transportType") String transportType,
            @Param("distance") int distance
    );
}
