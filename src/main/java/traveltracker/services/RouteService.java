package traveltracker.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import traveltracker.entities.Route;
import traveltracker.repositories.RouteRepository;

import java.util.Optional;

@Service
public class RouteService {
    private final RouteRepository routeRepository;

    @Autowired
    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public Optional<Route> getRouteById(Integer id) {
        return routeRepository.findById(id);
    }

    public Route addRoute(Route route) {
        return routeRepository.save(route);
    }

    public Route updateRoute(Integer routeId, Route routeDetails) {
        Route existingRoute = routeRepository.findById(routeId)
                .orElseThrow(() -> new RuntimeException("Entity not found with id: " + routeId));

        existingRoute.setRouteCodeId(routeDetails.getRouteCodeId());
        existingRoute.setStation1Name(routeDetails.getStation1Name());
        existingRoute.setStation2Name(routeDetails.getStation2Name());
        existingRoute.setDistance(routeDetails.getDistance());

        return routeRepository.save(existingRoute);
    }

    @Transactional
    public boolean deleteRoute(Integer routeId) {
        if (routeRepository.existsById(routeId)) {
            routeRepository.deleteById(routeId);
            return true;
        }
        return false;
    }
}
