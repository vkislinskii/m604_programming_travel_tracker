package traveltracker.entities;

import jakarta.persistence.*;
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
    private RouteCode routeCodeId;

    @ManyToOne
    @JoinColumn(name = "station1_name")
    private Station station1Name;

    @ManyToOne
    @JoinColumn(name = "station2_name")
    private Station station2Name;

    private Integer distance;

}