package traveltracker.entities;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String firstName;
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "current_city_id")
    private City currentCity;

    private LocalDate registrationDate;
}
