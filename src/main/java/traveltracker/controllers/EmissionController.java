package traveltracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import traveltracker.entities.City;
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
}
