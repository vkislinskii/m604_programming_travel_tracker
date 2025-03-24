package traveltracker.services;

import jakarta.transaction.Transactional;
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

    @Transactional
    public boolean deleteRouteCode(String routeCodeId) {
        if (routeCodeRepository.existsById(routeCodeId)) {
            routeCodeRepository.deleteById(routeCodeId);
            return true;
        }
        return false;
    }
}
