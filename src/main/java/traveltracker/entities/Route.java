package traveltracker.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "routes")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer routeId;

    @ManyToOne
    @JoinColumn(name = "route_code_id")
    @NotNull(message = "Route Code Id is required")
    private RouteCode routeCodeId;

    @ManyToOne
    @JoinColumn(name = "station1_name")
    @NotBlank(message = "Station1 Name is required")
    private Station station1Name;

    @ManyToOne
    @JoinColumn(name = "station2_name")
    @NotBlank(message = "Station2 Name is required")
    private Station station2Name;

    @NotNull(message = "Distance is required")
    private Integer distance;

}