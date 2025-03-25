package traveltracker.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import traveltracker.entities.TripDetail;

import java.util.List;
import java.util.Optional;

public interface TripDetailRepository extends JpaRepository<TripDetail, Integer>{

    Optional<TripDetail> findByTripDetailId(Integer tripDetailId);

    List<TripDetail> findByTripId_TripId(Integer tripId);
}
