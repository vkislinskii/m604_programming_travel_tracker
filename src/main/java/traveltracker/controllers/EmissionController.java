package traveltracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import traveltracker.entities.Emission;
import traveltracker.services.EmissionService;

import java.util.Optional;

@RestController
@RequestMapping("/emissions")
public class EmissionController {
    private final EmissionService emissionService;

    @Autowired
    public EmissionController(EmissionService emissionService) {
        this.emissionService = emissionService;
    }

    @GetMapping("/{id}")
    public Optional<Emission> getEmissionById(@PathVariable Integer id) {
        return emissionService.getEmissionById(id);
    }
}
