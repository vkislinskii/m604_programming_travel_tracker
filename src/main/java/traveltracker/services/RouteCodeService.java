package traveltracker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import traveltracker.entities.Interest;
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

    public RouteCode addRouteCode(RouteCode routeCode) {
        return routeCodeRepository.save(routeCode);
    }

    public RouteCode updateRouteCode(String routeCodeId, RouteCode routeCodeDetails) {
        RouteCode existingRouteCode = routeCodeRepository.findById(routeCodeId)
                .orElseThrow(() -> new RuntimeException("Entity not found with id: " + routeCodeId));

        existingRouteCode.setRouteName(routeCodeDetails.getRouteName());
        existingRouteCode.setOperator(routeCodeDetails.getOperator());

        return routeCodeRepository.save(existingRouteCode);
    }
}
