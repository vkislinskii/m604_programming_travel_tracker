package traveltracker.entities;
import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;

@Data
@Entity
@Table(name = "user_interests")
public class UserInterest {
    @EmbeddedId
    private UserInterestId id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId("interestId")
    @JoinColumn(name = "interest_id")
    private Interest interest;
}
