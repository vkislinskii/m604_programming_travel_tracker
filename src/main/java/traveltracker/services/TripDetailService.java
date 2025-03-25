package traveltracker.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import traveltracker.ResourceNotFoundException;
import traveltracker.entities.TripDetail;
import traveltracker.repositories.TripDetailRepository;

@Service
public class TripDetailService {
    private final TripDetailRepository tripDetailRepository;

    @Autowired
    public TripDetailService(TripDetailRepository tripDetailRepository) {
        this.tripDetailRepository = tripDetailRepository;
    }

    public TripDetail getRoutesByTripId(Integer id) {
        return tripDetailRepository.findByTripDetailId(id)
                .orElseThrow(() -> new ResourceNotFoundException("No routes found for trip ID: " + id));
    }

    public TripDetail addTripDetail(TripDetail tripDetail) {
        return tripDetailRepository.save(tripDetail);
    }

    public TripDetail updateTripDetail(Integer tripDetailId, TripDetail tripDetailDetails) {
        TripDetail existingTripDetail = tripDetailRepository.findById(tripDetailId)
                .orElseThrow(() -> new ResourceNotFoundException("Trip Details not found with id: " + tripDetailId));

        existingTripDetail.setRouteId(tripDetailDetails.getRouteId());
        existingTripDetail.setTripId(tripDetailDetails.getTripId());

        return tripDetailRepository.save(existingTripDetail);
    }

    @Transactional
    public void deleteTripDetail(Integer tripDetailId) {
        tripDetailRepository.findById(tripDetailId)
                .orElseThrow(() -> new ResourceNotFoundException("Trip Details not found with id: " + tripDetailId));
        tripDetailRepository.deleteById(tripDetailId);
    }
}
