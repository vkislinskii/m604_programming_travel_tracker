package traveltracker.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import traveltracker.entities.Trip;

import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Integer>{

    List<Trip> findByUserId_UserId(Integer userId);
}
