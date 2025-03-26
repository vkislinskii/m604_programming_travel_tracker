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

    @Column(length = 50)
    private String routeName;

    @Column(length = 50)
    private String operator;
}
