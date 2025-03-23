package traveltracker.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import traveltracker.entities.Interest;

public interface InterestRepository extends JpaRepository<Interest, Integer>{
}
