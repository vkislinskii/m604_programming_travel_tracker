package traveltracker.services;

import jakarta.transaction.Transactional;
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

    public Emission addEmission(Emission emission) {
        return emissionRepository.save(emission);
    }

    public Emission updateEmission(Integer emissionId, Emission emissionDetails) {
        Emission existingEmission = emissionRepository.findById(emissionId)
                .orElseThrow(() -> new RuntimeException("Entity not found with id: " + emissionId));

        existingEmission.setTransportType(emissionDetails.getTransportType());
        existingEmission.setMinDistance(emissionDetails.getMinDistance());
        existingEmission.setMaxDistance(emissionDetails.getMaxDistance());
        existingEmission.setCo2Coef(emissionDetails.getCo2Coef());

        return emissionRepository.save(existingEmission);
    }

    @Transactional
    public boolean deleteEmission(Integer emissionId) {
        if (emissionRepository.existsById(emissionId)) {
            emissionRepository.deleteById(emissionId);
            return true;
        }
        return false;
    }
}
