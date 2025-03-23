package traveltracker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import traveltracker.entities.RouteCode;
import traveltracker.repositories.RouteCodeRepository;

import java.util.Optional;

@Service
public class RouteCodeService {
    private final RouteCodeRepository routeCodeRepository;

    @Autowired
    public RouteCodeService(RouteCodeRepository routeCodeRepository) {
        this.routeCodeRepository = routeCodeRepository;
    }

    public Optional<RouteCode> getRouteCodeById(Integer id) {
        return routeCodeRepository.findById(String.valueOf(id));
    }
}
