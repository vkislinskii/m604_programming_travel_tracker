package traveltracker.entities;
import jakarta.persistence.*;
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
    private City city;

    @ManyToOne
    @MapsId("interestId")
    @JoinColumn(name = "interest_id")
    private Interest interest;
}

