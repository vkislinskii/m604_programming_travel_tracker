package traveltracker.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "emissions")
public class Emission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer emissionId;

    @ManyToOne
    @JoinColumn(name = "transport_type")
    @NotBlank(message = "Transport Type is required")
    private TransportType transportType;

    private Integer minDistance;
    private Integer maxDistance;
    @NotNull(message = "CO2 Coefficient is required")
    private Double co2Coef;

}