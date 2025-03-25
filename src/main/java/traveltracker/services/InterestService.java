package traveltracker.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import traveltracker.ResourceNotFoundException;
import traveltracker.entities.Interest;
import traveltracker.repositories.InterestRepository;

import java.util.List;

@Service
public class InterestService {
    private final InterestRepository interestRepository;

    @Autowired
    public InterestService(InterestRepository interestRepository) {
        this.interestRepository = interestRepository;
    }

    public List<Interest> getAllInterests() {
        List<Interest> interests = interestRepository.findAll();
        if (interests.isEmpty()) {
            throw new ResourceNotFoundException("No interests types were found");
        }
        return interests;
    }

    public Interest addInterest(Interest interest) {
        return interestRepository.save(interest);
    }

    public Interest updateInterest(Integer interestId, Interest interestDetails) {
        Interest existingInterest = interestRepository.findById(interestId)
                .orElseThrow(() -> new ResourceNotFoundException("Interest not found with id: " + interestId));

        existingInterest.setInterestName(interestDetails.getInterestName());

        return interestRepository.save(existingInterest);
    }

    @Transactional
    public void deleteInterest(Integer interestId) {
        interestRepository.findById(interestId)
                .orElseThrow(() -> new ResourceNotFoundException("Interest not found with id: " + interestId));
        interestRepository.deleteById(interestId);
    }
}

