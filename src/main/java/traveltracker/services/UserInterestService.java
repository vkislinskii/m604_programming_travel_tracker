package traveltracker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import traveltracker.entities.UserInterest;
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
}
