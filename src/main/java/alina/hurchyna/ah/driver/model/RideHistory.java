package alina.hurchyna.ah.driver.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@Entity
public class RideHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long rideId;
    private LocalDateTime rideDate;
    private boolean completed;


    public RideHistory() {

    }

    public RideHistory(Long userId, Long rideId, LocalDateTime rideDate, boolean completed) {
        this.userId = userId;
        this.rideId = rideId;
        this.rideDate = rideDate;
        this.completed = completed;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RideHistory that = (RideHistory) o;
        return completed == that.completed &&
                Objects.equals(id, that.id) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(rideId, that.rideId) &&
                Objects.equals(rideDate, that.rideDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, rideId, rideDate, completed);
    }

    @Override
    public String toString() {
        return "RideHistory{" +
                "id=" + id +
                ", userId=" + userId +
                ", rideId=" + rideId +
                ", rideDate=" + rideDate +
                ", completed=" + completed +
                '}';
    }
}
