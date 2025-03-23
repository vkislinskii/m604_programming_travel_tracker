package traveltracker.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import traveltracker.entities.User;
import traveltracker.entities.UserInterest;

import java.util.List;
import java.util.Optional;

public interface UserInterestRepository extends JpaRepository<UserInterest, Integer>{
    Optional<UserInterest> findByUser(User user);

    List<UserInterest> findByUserUserId(Integer id);
}
