package traveltracker.services;

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
}
