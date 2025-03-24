package traveltracker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
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

    public TransportType addTransportType(TransportType transportType) {
        return transportTypeRepository.save(transportType);
    }
}
