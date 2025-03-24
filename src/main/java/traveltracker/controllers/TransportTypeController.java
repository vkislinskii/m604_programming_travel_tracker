package traveltracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import traveltracker.entities.Route;
import traveltracker.entities.TransportType;
import traveltracker.repositories.TransportTypeRepository;
import traveltracker.services.TransportTypeService;

import java.util.List;

@RestController
@RequestMapping("/transport-types")
public class TransportTypeController {
    private final TransportTypeService transportTypeService;
    private final TransportTypeRepository transportTypeRepository;

    @Autowired
    public TransportTypeController(TransportTypeService transportTypeService, TransportTypeRepository transportTypeRepository) {
        this.transportTypeService = transportTypeService;
        this.transportTypeRepository = transportTypeRepository;
    }

    @GetMapping("/all")
    public List<TransportType> getAllTransportTypes() {
        return transportTypeService.getAllTransportTypes();
    }

    @PostMapping("/add")
    public TransportType addTransportType(@RequestBody TransportType transportType) {
        return transportTypeService.addTransportType(transportType);
    }
}
