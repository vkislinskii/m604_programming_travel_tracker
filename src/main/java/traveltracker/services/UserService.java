package traveltracker.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import traveltracker.ResourceNotFoundException;
import traveltracker.entities.*;
import traveltracker.repositories.*;

import java.util.Comparator;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final TripDetailRepository tripDetailRepository;
    private final EmissionRepository emissionRepository;
    private final TripRepository tripRepository;

    @Autowired
    public UserService(UserRepository userRepository,
                       TripDetailRepository tripDetailRepository,
                       EmissionRepository emissionRepository,
                       TripRepository tripRepository) {
        this.userRepository = userRepository;
        this.tripDetailRepository = tripDetailRepository;
        this.emissionRepository = emissionRepository;
        this.tripRepository = tripRepository;
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Integer userId, User userDetails) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

        existingUser.setFirstName(userDetails.getFirstName());
        existingUser.setLastName(userDetails.getLastName());
        existingUser.setCurrentCity(userDetails.getCurrentCity());
        existingUser.setRegistrationDate(userDetails.getRegistrationDate());

        return userRepository.save(existingUser);
    }

    @Transactional
    public void deleteUser(Integer userId) {
        userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
        userRepository.deleteById(userId);
    }

    public String calculateUserLastTripEmission(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
        List<Trip> trips = tripRepository.findByUserId_UserId(userId);
        Trip latestTrip = trips.stream()
                .max(Comparator.comparing(Trip::getTripDate))
                .orElseThrow(() -> new ResourceNotFoundException("Trips not found for user id: " + userId));
        int tripId = latestTrip.getTripId();
        City city = latestTrip.getCityArrivalId();
        String cityArrival = city.getCityName();
        double totalEmissions = TripService.calculateTripEmissions(tripId, tripDetailRepository, emissionRepository);

        return "User " + user.getFirstName() + " " + user.getLastName() + " has the last trip to " + cityArrival +
                ".\n\nCarbon emissions were " + totalEmissions + " kg CO2";
    }
}
