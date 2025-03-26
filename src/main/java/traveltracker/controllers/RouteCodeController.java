package traveltracker.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import traveltracker.entities.RouteCode;
import traveltracker.services.RouteCodeService;


@RestController
@RequestMapping("/api/route-codes")
public class RouteCodeController {
    private final RouteCodeService routeCodeService;

    @Autowired
    public RouteCodeController(RouteCodeService routeCodeService) {
        this.routeCodeService = routeCodeService;
    }

    @GetMapping("/{routeCodeId}")
    public ResponseEntity<RouteCode> getRouteCodeById(@PathVariable Integer routeCodeId) {
        return ResponseEntity.ok(routeCodeService.getRouteCodeById(routeCodeId));
    }

    @PostMapping("/add")
    public ResponseEntity<RouteCode> addRouteCode(@Valid @RequestBody RouteCode routeCode) {
        return ResponseEntity.ok(routeCodeService.addRouteCode(routeCode));
    }

    @PutMapping("/{routeCodeId}")
    public ResponseEntity<RouteCode> updateRouteCode(
            @PathVariable String routeCodeId,
            @Valid @RequestBody RouteCode routeCodeDetails) {

        RouteCode updatedEntity = routeCodeService.updateRouteCode(routeCodeId, routeCodeDetails);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/{routeCodeId}")
    public ResponseEntity<RouteCode> deleteRouteCode(@PathVariable String routeCodeId) {
        routeCodeService.deleteRouteCode(routeCodeId);
        return ResponseEntity.noContent().build();
    }
}
