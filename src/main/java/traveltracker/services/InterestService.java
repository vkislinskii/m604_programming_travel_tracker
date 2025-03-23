package traveltracker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import traveltracker.entities.Interest;
import traveltracker.entities.Trip;
import traveltracker.entities.User;
import traveltracker.repositories.InterestRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InterestService {
    private final InterestRepository interestRepository;

    @Autowired
    public InterestService(InterestRepository interestRepository) {
        this.interestRepository = interestRepository;
    }

    public List<Interest> getAllInterests() {
        return interestRepository.findAll(); //getTripsByTripId
    }
}
