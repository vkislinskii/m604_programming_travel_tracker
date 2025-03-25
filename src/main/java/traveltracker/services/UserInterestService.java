package traveltracker.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import traveltracker.ResourceNotFoundException;
import traveltracker.entities.UserInterest;
import traveltracker.entities.UserInterestId;
import traveltracker.repositories.UserInterestRepository;

import java.util.List;

@Service
public class UserInterestService {
    private final UserInterestRepository userInterestRepository;

    @Autowired
    public UserInterestService(UserInterestRepository userInterestRepository) {
        this.userInterestRepository = userInterestRepository;
    }

    public List<UserInterest> getInterestByUserId(Integer id) {
        List<UserInterest> interests = userInterestRepository.findByUserUserId(id);
        if (interests.isEmpty()) {
            throw new ResourceNotFoundException("No interests found for user ID: " + id);
        }
        return interests;
    }

    public UserInterest addUserInterest(UserInterest userInterest) {
        return userInterestRepository.save(userInterest);
    }

    @Transactional
    public void deleteUserInterest(Integer userId, Integer interestId) {
        UserInterestId id = new UserInterestId();
        id.setUserId(userId);
        id.setInterestId(interestId);
        userInterestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
        userInterestRepository.deleteById(id);
    }
}
