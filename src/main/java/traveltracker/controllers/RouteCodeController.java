package traveltracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import traveltracker.entities.RouteCode;
import traveltracker.repositories.RouteCodeRepository;
import traveltracker.services.RouteCodeService;

import java.util.Optional;

@RestController
@RequestMapping("/route-codes")
public class RouteCodeController {
    private final RouteCodeService routeCodeService;
    private final RouteCodeRepository routeCodeRepository;

    @Autowired
    public RouteCodeController(RouteCodeService routeCodeService, RouteCodeRepository routeCodeRepository) {
        this.routeCodeService = routeCodeService;
        this.routeCodeRepository = routeCodeRepository;
    }

    @GetMapping("/{id}")
    public Optional<RouteCode> getRouteCodeById(@PathVariable Integer id) {
        return routeCodeService.getRouteCodeById(id);
    }

    @PostMapping("/add")
    public RouteCode addRouteCode(@RequestBody RouteCode routeCode) {
        return routeCodeService.addRouteCode(routeCode);
    }

    @PutMapping("/update-{routeCodeId}")
    public ResponseEntity<RouteCode> updateRouteCode(
            @PathVariable String routeCodeId,
            @RequestBody RouteCode routeCodeDetails) {

        RouteCode updatedEntity = routeCodeService.updateRouteCode(routeCodeId, routeCodeDetails);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/delete-{routeCodeId}")
    public ResponseEntity<Void> deleteRouteCode(@PathVariable String routeCodeId) {
        boolean isDeleted = routeCodeService.deleteRouteCode(routeCodeId);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
