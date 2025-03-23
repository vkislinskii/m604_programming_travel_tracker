package traveltracker.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "route_codes")
public class RouteCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer routeCodeId;

    private String routeName;

    private String operator;
}
