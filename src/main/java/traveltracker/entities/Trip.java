package traveltracker.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "trips")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tripId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull(message = "User ID is required")
    private User userId;

    @ManyToOne
    @JoinColumn(name = "city_departure_id")
    @NotNull(message = "City Departure ID is required")
    private City cityDepartureId;

    @ManyToOne
    @JoinColumn(name = "city_arrival_id")
    @NotNull(message = "City Arrival ID is required")
    private City cityArrivalId;

    private LocalDate tripDate;

    private Integer tripRating;

}