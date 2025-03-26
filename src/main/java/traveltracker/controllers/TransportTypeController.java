package traveltracker.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import traveltracker.entities.TransportType;
import traveltracker.services.TransportTypeService;

import java.util.List;

@RestController
@RequestMapping("/api/transport-types")
public class TransportTypeController {
    private final TransportTypeService transportTypeService;

    @Autowired
    public TransportTypeController(TransportTypeService transportTypeService) {
        this.transportTypeService = transportTypeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<TransportType>> getAllTransportTypes() {
        return ResponseEntity.ok(transportTypeService.getAllTransportTypes());
    }

    @PostMapping("/add")
    public ResponseEntity<TransportType> addTransportType(@Valid @RequestBody TransportType transportType) {
        return ResponseEntity.ok(transportTypeService.addTransportType(transportType));
    }

    @DeleteMapping("/{transportType}")
    public ResponseEntity<TransportType> deleteTransportType(@PathVariable String transportType) {
        transportTypeService.deleteTransportType(transportType);
        return ResponseEntity.noContent().build();
    }
}
