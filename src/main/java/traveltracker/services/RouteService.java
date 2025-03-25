package traveltracker.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import traveltracker.ResourceNotFoundException;
import traveltracker.entities.Route;
import traveltracker.repositories.RouteRepository;

@Service
public class RouteService {
    private final RouteRepository routeRepository;

    @Autowired
    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public Route getRouteById(Integer id) {
        return routeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Route not found with id: " + id));
    }

    public Route addRoute(Route route) {
        return routeRepository.save(route);
    }

    public Route updateRoute(Integer routeId, Route routeDetails) {
        Route existingRoute = routeRepository.findById(routeId)
                .orElseThrow(() -> new ResourceNotFoundException("Route not found with id: " + routeId));

        existingRoute.setRouteCodeId(routeDetails.getRouteCodeId());
        existingRoute.setStation1Name(routeDetails.getStation1Name());
        existingRoute.setStation2Name(routeDetails.getStation2Name());
        existingRoute.setDistance(routeDetails.getDistance());

        return routeRepository.save(existingRoute);
    }

    @Transactional
    public void deleteRoute(Integer routeId) {
        routeRepository.findById(routeId)
                .orElseThrow(() -> new ResourceNotFoundException("Route not found with id: " + routeId));
        routeRepository.deleteById(routeId);
    }
}
