package traveltracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import traveltracker.entities.Emission;
import traveltracker.entities.RouteCode;
import traveltracker.services.RouteCodeService;

import java.util.Optional;

@RestController
@RequestMapping("/route-codes")
public class RouteCodeController {
    private final RouteCodeService routeCodeService;

    @Autowired
    public RouteCodeController(RouteCodeService routeCodeService) {
        this.routeCodeService = routeCodeService;
    }

    @GetMapping("/{id}")
    public Optional<RouteCode> getRouteCodeById(@PathVariable Integer id) {
        return routeCodeService.getRouteCodeById(id);
    }
}
