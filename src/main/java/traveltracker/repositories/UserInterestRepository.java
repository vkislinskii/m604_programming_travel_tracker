package traveltracker.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import traveltracker.entities.User;
import traveltracker.entities.UserInterest;
import traveltracker.entities.UserInterestId;

import java.util.List;
import java.util.Optional;

public interface UserInterestRepository extends JpaRepository<UserInterest, UserInterestId>{
    Optional<UserInterest> findByUser(User user);

    List<UserInterest> findByUserUserId(Integer id);
}
