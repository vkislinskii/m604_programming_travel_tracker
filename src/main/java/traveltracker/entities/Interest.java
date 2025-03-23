package traveltracker.entities;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "interests")
public class Interest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer interestId;

    private String interestName;
}
