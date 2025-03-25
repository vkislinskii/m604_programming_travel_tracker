package traveltracker.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import traveltracker.entities.Route;
import traveltracker.repositories.RouteRepository;
import traveltracker.services.RouteService;


@RestController
@RequestMapping("/routes")
public class RouteController {
    private final RouteService routeService;
    private final RouteRepository routeRepository;

    @Autowired
    public RouteController(RouteService routeService, RouteRepository routeRepository) {
        this.routeService = routeService;
        this.routeRepository = routeRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Route> getRouteById(@PathVariable Integer id) {
        return ResponseEntity.ok(routeService.getRouteById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Route> addRoute(@Valid @RequestBody Route route) {
        return ResponseEntity.ok(routeService.addRoute(route));
    }

    @PutMapping("/update-{routeId}")
    public ResponseEntity<Route> updateRoute(
            @PathVariable Integer routeId,
            @Valid @RequestBody Route routeDetails) {

        Route updatedEntity = routeService.updateRoute(routeId, routeDetails);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/delete-{routeId}")
    public ResponseEntity<Route> deleteRoute(@PathVariable Integer routeId) {
        routeService.deleteRoute(routeId);
        return ResponseEntity.noContent().build();
    }
}
