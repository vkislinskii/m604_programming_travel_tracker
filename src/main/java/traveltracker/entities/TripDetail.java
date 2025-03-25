package traveltracker.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "trip_details")
public class TripDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tripDetailId;

    @ManyToOne
    @JoinColumn(name = "trip_id")
    @NotNull(message = "Trip ID is required")
    private Trip tripId;

    @ManyToOne
    @JoinColumn(name = "route_id")
    @NotNull(message = "Route ID is required")
    private Route routeId;

}