package traveltracker.entities;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CityInterestId implements Serializable {
    private Integer cityId;
    private Integer interestId;
}
