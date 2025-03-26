package traveltracker.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import traveltracker.entities.Emission;
import traveltracker.repositories.EmissionRepository;
import traveltracker.services.EmissionService;


@RestController
@RequestMapping("/api/emissions")
public class EmissionController {
    private final EmissionService emissionService;

    @Autowired
    public EmissionController(EmissionService emissionService) {
        this.emissionService = emissionService;
    }

    @GetMapping("/{emissionId}")
    public ResponseEntity<Emission> getEmissionById(@PathVariable Integer emissionId) {
        return ResponseEntity.ok(emissionService.getEmissionById(emissionId));
    }

    @PostMapping("/add")
    public ResponseEntity<Emission> addEmission(@Valid @RequestBody Emission emission) {
        return ResponseEntity.ok(emissionService.addEmission(emission));
    }

    @PutMapping("/{emissionId}")
    public ResponseEntity<Emission> updateEmission(
            @PathVariable Integer emissionId,
            @Valid @RequestBody Emission emissionDetails) {

        Emission updatedEntity = emissionService.updateEmission(emissionId, emissionDetails);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/{emissionId}")
    public ResponseEntity<Emission> deleteEmission(@PathVariable Integer emissionId) {
        emissionService.deleteEmission(emissionId);
        return ResponseEntity.noContent().build();
    }
}
