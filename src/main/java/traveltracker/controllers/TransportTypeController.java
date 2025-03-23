package traveltracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import traveltracker.entities.TransportType;
import traveltracker.services.TransportTypeService;

import java.util.List;

@RestController
@RequestMapping("/transport-types")
public class TransportTypeController {
    private final TransportTypeService transportTypeService;

    @Autowired
    public TransportTypeController(TransportTypeService transportTypeService) {
        this.transportTypeService = transportTypeService;
    }

    @GetMapping("/all")
    public List<TransportType> getAllTransportTypes() {
        return transportTypeService.getAllTransportTypes();
    }
}
