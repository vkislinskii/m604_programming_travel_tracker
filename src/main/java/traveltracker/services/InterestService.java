package traveltracker.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import traveltracker.entities.Interest;
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

    public Interest addInterest(Interest interest) {
        return interestRepository.save(interest);
    }

    public Interest updateInterest(Integer interestId, Interest interestDetails) {
        Interest existingInterest = interestRepository.findById(interestId)
                .orElseThrow(() -> new RuntimeException("Entity not found with id: " + interestId));

        existingInterest.setInterestName(interestDetails.getInterestName());

        return interestRepository.save(existingInterest);
    }

    @Transactional
    public boolean deleteInterest(Integer interestId) {
        if (interestRepository.existsById(interestId)) {
            interestRepository.deleteById(interestId);
            return true;
        }
        return false;
    }
}

