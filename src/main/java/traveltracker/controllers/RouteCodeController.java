package traveltracker.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import traveltracker.entities.RouteCode;
import traveltracker.repositories.RouteCodeRepository;
import traveltracker.services.RouteCodeService;


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
    public ResponseEntity<RouteCode> getRouteCodeById(@PathVariable Integer id) {
        return ResponseEntity.ok(routeCodeService.getRouteCodeById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<RouteCode> addRouteCode(@Valid @RequestBody RouteCode routeCode) {
        return ResponseEntity.ok(routeCodeService.addRouteCode(routeCode));
    }

    @PutMapping("/update-{routeCodeId}")
    public ResponseEntity<RouteCode> updateRouteCode(
            @PathVariable String routeCodeId,
            @Valid @RequestBody RouteCode routeCodeDetails) {

        RouteCode updatedEntity = routeCodeService.updateRouteCode(routeCodeId, routeCodeDetails);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/delete-{routeCodeId}")
    public ResponseEntity<RouteCode> deleteRouteCode(@PathVariable String routeCodeId) {
        routeCodeService.deleteRouteCode(routeCodeId);
        return ResponseEntity.noContent().build();
    }
}
