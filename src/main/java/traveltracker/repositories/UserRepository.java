package traveltracker.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import traveltracker.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
