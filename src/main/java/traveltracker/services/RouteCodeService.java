package traveltracker.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import traveltracker.ResourceNotFoundException;
import traveltracker.entities.RouteCode;
import traveltracker.repositories.RouteCodeRepository;


@Service
public class RouteCodeService {
    private final RouteCodeRepository routeCodeRepository;

    @Autowired
    public RouteCodeService(RouteCodeRepository routeCodeRepository) {
        this.routeCodeRepository = routeCodeRepository;
    }

    public RouteCode getRouteCodeById(Integer id) {
        return routeCodeRepository.findById(String.valueOf(id))
                .orElseThrow(() -> new ResourceNotFoundException("Route Code not found with id: " + id));
    }

    public RouteCode addRouteCode(RouteCode routeCode) {
        return routeCodeRepository.save(routeCode);
    }

    public RouteCode updateRouteCode(String routeCodeId, RouteCode routeCodeDetails) {
        RouteCode existingRouteCode = routeCodeRepository.findById(routeCodeId)
                .orElseThrow(() -> new ResourceNotFoundException("Route Code not found with id: " + routeCodeId));

        existingRouteCode.setRouteName(routeCodeDetails.getRouteName());
        existingRouteCode.setOperator(routeCodeDetails.getOperator());

        return routeCodeRepository.save(existingRouteCode);
    }

    @Transactional
    public void deleteRouteCode(String routeCodeId) {
        routeCodeRepository.findById(routeCodeId)
                .orElseThrow(() -> new ResourceNotFoundException("Route Code not found with id: " + routeCodeId));
        routeCodeRepository.deleteById(routeCodeId);
    }
}
