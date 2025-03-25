package traveltracker.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<List<TransportType>> getAllTransportTypes() {
        return ResponseEntity.ok(transportTypeService.getAllTransportTypes());
    }

    @PostMapping("/add")
    public ResponseEntity<TransportType> addTransportType(@Valid @RequestBody TransportType transportType) {
        return ResponseEntity.ok(transportTypeService.addTransportType(transportType));
    }

    @DeleteMapping("/delete-{transportType}")
    public ResponseEntity<TransportType> deleteTransportType(@PathVariable String transportType) {
        transportTypeService.deleteTransportType(transportType);
        return ResponseEntity.noContent().build();
    }
}
