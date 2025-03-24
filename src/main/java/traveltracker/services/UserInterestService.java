package traveltracker.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import traveltracker.entities.UserInterest;
import traveltracker.entities.UserInterestId;
import traveltracker.repositories.UserInterestRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserInterestService {
    private final UserInterestRepository userInterestRepository;

    @Autowired
    public UserInterestService(UserInterestRepository userInterestRepository) {
        this.userInterestRepository = userInterestRepository;
    }

    public List<UserInterest> getInterestByUserId(Integer id) {
        return userInterestRepository.findByUserUserId(id);
    }

    public UserInterest addUserInterest(UserInterest userInterest) {
        return userInterestRepository.save(userInterest);
    }

    @Transactional
    public boolean deleteUserInterest(Integer userId, Integer interestId) {
        UserInterestId id = new UserInterestId();
        id.setUserId(userId);
        id.setInterestId(interestId);
        if (userInterestRepository.existsById(id)) {
            userInterestRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
