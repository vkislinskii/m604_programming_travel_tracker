package traveltracker.entities;

import jakarta.persistence.*;
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
    private Trip tripId;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route routeId;

}