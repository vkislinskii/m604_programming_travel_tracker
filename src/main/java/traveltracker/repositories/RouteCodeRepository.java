package traveltracker.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import traveltracker.entities.RouteCode;

public interface RouteCodeRepository extends JpaRepository<RouteCode, String>{
}
