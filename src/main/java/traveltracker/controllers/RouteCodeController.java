package traveltracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import traveltracker.entities.City;
import traveltracker.entities.Emission;
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
}
