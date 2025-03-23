package traveltracker.entities;

import jakarta.persistence.*;
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
    private User userId;

    @ManyToOne
    @JoinColumn(name = "city_departure_id")
    private City cityDepartureId;

    @ManyToOne
    @JoinColumn(name = "city_arrival_id")
    private City cityArrivalId;

    private LocalDate tripDate;

    private Integer tripRating;

}