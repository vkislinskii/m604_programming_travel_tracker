package traveltracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import traveltracker.entities.Emission;
import traveltracker.repositories.EmissionRepository;
import traveltracker.services.EmissionService;

import java.util.Optional;

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
    public Optional<Emission> getEmissionById(@PathVariable Integer id) {
        return emissionService.getEmissionById(id);
    }

    @PostMapping("/add")
    public Emission addEmission(@RequestBody Emission emission) {
        return emissionService.addEmission(emission);
    }

    @PutMapping("/update-{emissionId}")
    public ResponseEntity<Emission> updateEmission(
            @PathVariable Integer emissionId,
            @RequestBody Emission emissionDetails) {

        Emission updatedEntity = emissionService.updateEmission(emissionId, emissionDetails);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/delete-{emissionId}")
    public ResponseEntity<Void> deleteEmission(@PathVariable Integer emissionId) {
        boolean isDeleted = emissionService.deleteEmission(emissionId);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
