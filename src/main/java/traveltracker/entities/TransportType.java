package traveltracker.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "transport_types")
public class TransportType {
    @Id
    @Column(length = 50)
    private String transportType;
}