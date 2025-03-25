package traveltracker.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cityId;

    @NotBlank(message = "City name is required")
    private String cityName;
    @NotBlank(message = "Country is required")
    private String country;
}
