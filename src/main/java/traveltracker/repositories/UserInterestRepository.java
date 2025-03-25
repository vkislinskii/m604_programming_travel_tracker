package traveltracker.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import traveltracker.entities.UserInterest;
import traveltracker.entities.UserInterestId;

import java.util.List;

public interface UserInterestRepository extends JpaRepository<UserInterest, UserInterestId>{

    List<UserInterest> findByUserUserId(Integer id);
}
