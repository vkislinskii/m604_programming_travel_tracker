package traveltracker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import traveltracker.entities.Interest;
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
}
