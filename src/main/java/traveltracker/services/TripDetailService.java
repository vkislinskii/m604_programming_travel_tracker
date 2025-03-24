package traveltracker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import traveltracker.entities.Route;
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

    public TripDetail addTripDetail(TripDetail tripDetail) {
        return tripDetailRepository.save(tripDetail);
    }

    public TripDetail updateTripDetail(Integer tripDetailId, TripDetail tripDetailDetails) {
        TripDetail existingTripDetail = tripDetailRepository.findById(tripDetailId)
                .orElseThrow(() -> new RuntimeException("Entity not found with id: " + tripDetailId));

        existingTripDetail.setRouteId(tripDetailDetails.getRouteId());
        existingTripDetail.setTripId(tripDetailDetails.getTripId());

        return tripDetailRepository.save(existingTripDetail);
    }
}
