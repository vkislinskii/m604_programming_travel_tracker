package traveltracker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import traveltracker.entities.TripDetail;
import traveltracker.repositories.TripDetailRepository;

import java.util.Optional;

@Service
public class TripDetailService {
    private final TripDetailRepository tripDetailRepository;

    @Autowired
    public TripDetailService(TripDetailRepository tripDetailRepository) {
        this.tripDetailRepository = tripDetailRepository;
    }

    public Optional<TripDetail> getRoutesByTripId(Integer id) {
        return tripDetailRepository.findByTripDetailId(id);
    }
}
