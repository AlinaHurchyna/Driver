package alina.hurchyna.ah.driver.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class RideOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long clientId;
    private String startLocation;
    private String destination;

    public RideOrder() {
    }

    public RideOrder(Long clientId, String startLocation, String destination) {
        this.clientId = clientId;
        this.startLocation = startLocation;
        this.destination = destination;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RideOrder rideOrder = (RideOrder) o;
        return Objects.equals(id, rideOrder.id) &&
                Objects.equals(clientId, rideOrder.clientId) &&
                Objects.equals(startLocation, rideOrder.startLocation) &&
                Objects.equals(destination, rideOrder.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientId, startLocation, destination);
    }

    @Override
    public String toString() {
        return "RideOrder{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", startLocation='" + startLocation + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }
}
