package traveltracker.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import traveltracker.entities.*;
import traveltracker.repositories.*;

import java.util.List;
import java.util.Optional;

@Service
public class TripService {
    private final TripRepository tripRepository;
    private final TripDetailRepository tripDetailRepository;
    private final RouteRepository routeRepository;
    private final EmissionRepository emissionRepository;

    @Autowired
    public TripService(
            TripRepository tripRepository,
            TripDetailRepository tripDetailRepository,
            RouteRepository routeRepository,
            EmissionRepository emissionRepository
    ) {
        this.tripRepository = tripRepository;
        this.tripDetailRepository = tripDetailRepository;
        this.routeRepository = routeRepository;
        this.emissionRepository = emissionRepository;
    }

    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    public Optional<Trip> getTripById(Integer id) {
        return tripRepository.findById(id);
    }

    public Trip addTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    public Trip updateTrip(Integer tripId, Trip tripDetails) {
        Trip existingTrip = tripRepository.findById(tripId)
                .orElseThrow(() -> new RuntimeException("Entity not found with id: " + tripId));

        existingTrip.setTripDate(tripDetails.getTripDate());
        existingTrip.setTripRating(tripDetails.getTripRating());
        existingTrip.setUserId(tripDetails.getUserId());
        existingTrip.setCityArrivalId(tripDetails.getCityArrivalId());
        existingTrip.setCityDepartureId(tripDetails.getCityDepartureId());

        return tripRepository.save(existingTrip);
    }

    @Transactional
    public boolean deleteTrip(Integer tripId) {
        if (tripRepository.existsById(tripId)) {
            tripRepository.deleteById(tripId);
            return true;
        }
        return false;
    }

    static double calculateTripEmissions(int tripId, TripDetailRepository tripDetailRepository, EmissionRepository emissionRepository) {
        List<TripDetail> tripDetails = tripDetailRepository.findByTripId_TripId(tripId);
        int totalDistance = 0;
        double totalEmissions = 0;
        for (TripDetail tripDetail : tripDetails) {
            Route routeId = tripDetail.getRouteId();
            int distance = routeId.getDistance();
            totalDistance += distance;
        }
        Emission emission = emissionRepository.findByTransportType_TransportType("Electric train");
        totalEmissions += totalDistance * emission.getCo2Coef();
        return totalEmissions;
    }

    public String sendTripEmissions(Integer tripId) {
        double totalEmissions = calculateTripEmissions(tripId, tripDetailRepository, emissionRepository);
        return "For trip#" + tripId + " carbon emissions were " + totalEmissions + " kg CO2";
    }

}
