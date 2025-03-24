package traveltracker.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import traveltracker.entities.TransportType;
import traveltracker.repositories.TransportTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TransportTypeService {
    private final TransportTypeRepository transportTypeRepository;

    @Autowired
    public TransportTypeService(TransportTypeRepository transportTypeRepository) {
        this.transportTypeRepository = transportTypeRepository;
    }

    public List<TransportType> getAllTransportTypes() {
        return transportTypeRepository.findAll();
    }

    public TransportType addTransportType(TransportType transportType) {
        return transportTypeRepository.save(transportType);
    }

    @Transactional
    public boolean deleteTransportType(String transportType) {
        if (transportTypeRepository.existsById(transportType)) {
            transportTypeRepository.deleteById(transportType);
            return true;
        }
        return false;
    }
}
