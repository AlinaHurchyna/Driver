package alina.hurchyna.ah.driver.model;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
@Entity
public class RideRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long clientId;
    private String startLocation;
    private String destination;
    private RideStatus status;
    @Getter
    private Long driverId;

    public RideRequest() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RideRequest that = (RideRequest) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(clientId, that.clientId) &&
                Objects.equals(startLocation, that.startLocation) &&
                Objects.equals(destination, that.destination) &&
                status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientId, startLocation, destination, status);
    }

    @Override
    public String toString() {
        return "RideRequest{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", startLocation='" + startLocation + '\'' +
                ", destination='" + destination + '\'' +
                ", status=" + status +
                '}';
    }

}

