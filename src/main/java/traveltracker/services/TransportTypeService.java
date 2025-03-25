package traveltracker.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import traveltracker.ResourceNotFoundException;
import traveltracker.entities.TransportType;
import traveltracker.repositories.TransportTypeRepository;

import java.util.List;

@Service
public class TransportTypeService {
    private final TransportTypeRepository transportTypeRepository;

    @Autowired
    public TransportTypeService(TransportTypeRepository transportTypeRepository) {
        this.transportTypeRepository = transportTypeRepository;
    }

    public List<TransportType> getAllTransportTypes() {
        List<TransportType> transportTypes = transportTypeRepository.findAll();
        if (transportTypes.isEmpty()) {
            throw new ResourceNotFoundException("No transport types were found");
        }
        return transportTypes;
    }

    public TransportType addTransportType(TransportType transportType) {
        return transportTypeRepository.save(transportType);
    }

    @Transactional
    public void deleteTransportType(String transportType) {
        transportTypeRepository.findById(transportType)
                .orElseThrow(() -> new ResourceNotFoundException("Transport Type not found with name: " + transportType));
        transportTypeRepository.deleteById(transportType);
    }
}
