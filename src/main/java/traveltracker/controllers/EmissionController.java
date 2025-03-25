package traveltracker.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import traveltracker.entities.Emission;
import traveltracker.repositories.EmissionRepository;
import traveltracker.services.EmissionService;


@RestController
@RequestMapping("/emissions")
public class EmissionController {
    private final EmissionService emissionService;
    private final EmissionRepository emissionRepository;

    @Autowired
    public EmissionController(EmissionService emissionService, EmissionRepository emissionRepository) {
        this.emissionService = emissionService;
        this.emissionRepository = emissionRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Emission> getEmissionById(@PathVariable Integer id) {
        return ResponseEntity.ok(emissionService.getEmissionById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Emission> addEmission(@Valid @RequestBody Emission emission) {
        return ResponseEntity.ok(emissionService.addEmission(emission));
    }

    @PutMapping("/update-{emissionId}")
    public ResponseEntity<Emission> updateEmission(
            @PathVariable Integer emissionId,
            @Valid @RequestBody Emission emissionDetails) {

        Emission updatedEntity = emissionService.updateEmission(emissionId, emissionDetails);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/delete-{emissionId}")
    public ResponseEntity<Emission> deleteEmission(@PathVariable Integer emissionId) {
        emissionService.deleteEmission(emissionId);
        return ResponseEntity.noContent().build();
    }
}
