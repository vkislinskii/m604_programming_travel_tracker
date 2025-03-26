package traveltracker.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import traveltracker.entities.Route;
import traveltracker.services.RouteService;


@RestController
@RequestMapping("/api/routes")
public class RouteController {
    private final RouteService routeService;

    @Autowired
    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/{routeId}")
    public ResponseEntity<Route> getRouteById(@PathVariable Integer routeId) {
        return ResponseEntity.ok(routeService.getRouteById(routeId));
    }

    @PostMapping("/add")
    public ResponseEntity<Route> addRoute(@Valid @RequestBody Route route) {
        return ResponseEntity.ok(routeService.addRoute(route));
    }

    @PutMapping("/{routeId}")
    public ResponseEntity<Route> updateRoute(
            @PathVariable Integer routeId,
            @Valid @RequestBody Route routeDetails) {

        Route updatedEntity = routeService.updateRoute(routeId, routeDetails);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/{routeId}")
    public ResponseEntity<Route> deleteRoute(@PathVariable Integer routeId) {
        routeService.deleteRoute(routeId);
        return ResponseEntity.noContent().build();
    }
}
