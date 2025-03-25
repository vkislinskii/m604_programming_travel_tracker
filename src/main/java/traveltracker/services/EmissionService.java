package traveltracker.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import traveltracker.ResourceNotFoundException;
import traveltracker.entities.Emission;
import traveltracker.repositories.EmissionRepository;


@Service
public class EmissionService {
    private final EmissionRepository emissionRepository;

    @Autowired
    public EmissionService(EmissionRepository emissionRepository) {
        this.emissionRepository = emissionRepository;
    }

    public Emission getEmissionById(Integer id) {
        return emissionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Emission not found with id: " + id));
    }

    public Emission addEmission(Emission emission) {
        return emissionRepository.save(emission);
    }

    public Emission updateEmission(Integer emissionId, Emission emissionDetails) {
        Emission existingEmission = emissionRepository.findById(emissionId)
                .orElseThrow(() -> new ResourceNotFoundException("Emission not found with id: " + emissionId));

        existingEmission.setTransportType(emissionDetails.getTransportType());
        existingEmission.setMinDistance(emissionDetails.getMinDistance());
        existingEmission.setMaxDistance(emissionDetails.getMaxDistance());
        existingEmission.setCo2Coef(emissionDetails.getCo2Coef());

        return emissionRepository.save(existingEmission);
    }

    @Transactional
    public void deleteEmission(Integer emissionId) {
        emissionRepository.findById(emissionId)
                .orElseThrow(() -> new ResourceNotFoundException("Emission not found with id: " + emissionId));
        emissionRepository.deleteById(emissionId);
    }
}
