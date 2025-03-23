package traveltracker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import traveltracker.entities.Emission;
import traveltracker.repositories.EmissionRepository;

import java.util.Optional;

@Service
public class EmissionService {
    private final EmissionRepository emissionRepository;

    @Autowired
    public EmissionService(EmissionRepository emissionRepository) {
        this.emissionRepository = emissionRepository;
    }

    public Optional<Emission> getEmissionById(Integer id) {
        return emissionRepository.findById(id);
    }
}
