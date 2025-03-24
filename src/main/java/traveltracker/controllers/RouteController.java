package traveltracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import traveltracker.entities.City;
import traveltracker.entities.Route;
import traveltracker.entities.RouteCode;
import traveltracker.repositories.RouteRepository;
import traveltracker.services.RouteService;

import java.util.Optional;

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
    public Optional<Route> getRouteById(@PathVariable Integer id) {
        return routeService.getRouteById(id);
    }

    @PostMapping("/add")
    public Route addRoute(@RequestBody Route route) {
        return routeService.addRoute(route);
    }

    @PutMapping("/update-{routeId}")
    public ResponseEntity<Route> updateRoute(
            @PathVariable Integer routeId,
            @RequestBody Route routeDetails) {

        Route updatedEntity = routeService.updateRoute(routeId, routeDetails);
        return ResponseEntity.ok(updatedEntity);
    }
}
