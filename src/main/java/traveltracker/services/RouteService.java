package traveltracker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
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
}
