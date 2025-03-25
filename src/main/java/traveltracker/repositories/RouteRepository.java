package traveltracker.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import traveltracker.entities.Route;

public interface RouteRepository extends JpaRepository<Route, Integer>{
}
