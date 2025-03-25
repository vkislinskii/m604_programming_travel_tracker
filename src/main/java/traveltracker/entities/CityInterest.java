package traveltracker.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "cities_interests")
public class CityInterest {
    @EmbeddedId
    private CityInterestId id;

    @ManyToOne
    @MapsId("cityId")
    @JoinColumn(name = "city_id")
    @NotNull(message = "City ID is required")
    private City city;

    @ManyToOne
    @MapsId("interestId")
    @JoinColumn(name = "interest_id")
    @NotNull(message = "Interest ID is required")
    private Interest interest;
}

