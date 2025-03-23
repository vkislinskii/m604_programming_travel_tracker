package traveltracker.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "stations")
public class Station {
    @Id
    @Column(length = 50)
    private String stationName;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
}