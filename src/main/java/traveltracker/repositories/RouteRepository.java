package traveltracker.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import traveltracker.entities.Emission;
import traveltracker.entities.Route;

public interface RouteRepository extends JpaRepository<Route, Integer>{
    /*@Query("SELECT r FROM RouteCode r " +
            "WHERE r.routeCode = :routeCode ")
    Emission findByTransportTypeAndDistance(
            @Param("transportType") String transportType
    );*/
}
