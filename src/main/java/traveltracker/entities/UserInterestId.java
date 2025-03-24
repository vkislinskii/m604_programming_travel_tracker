package traveltracker.entities;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserInterestId implements Serializable {
    private Integer userId;
    private Integer interestId;

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setInterestId(Integer interestId) {
        this.interestId = interestId;
    }
}
