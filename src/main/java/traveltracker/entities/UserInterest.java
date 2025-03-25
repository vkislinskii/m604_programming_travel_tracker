package traveltracker.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "user_interests")
public class UserInterest {
    @EmbeddedId
    private UserInterestId id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    @NotNull(message = "User ID is required")
    private User user;

    @ManyToOne
    @MapsId("interestId")
    @JoinColumn(name = "interest_id")
    @NotNull(message = "Interest ID is required")
    private Interest interest;
}
