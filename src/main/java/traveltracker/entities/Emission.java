package traveltracker.entities;

import jakarta.persistence.*;
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
    private TransportType transportType;

    private Integer minDistance;
    private Integer maxDistance;
    private Double co2Coef;

}