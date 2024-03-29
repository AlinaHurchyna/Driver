package alina.hurchyna.ah.driver.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Objects;

@Getter
@Setter
@Entity
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long driverId;
    private String clientName;
    private String destination;
    private boolean paymentByCard;

    public Ride(Long driverId, String clientName, String destination, boolean paymentByCard) {
        this.driverId = driverId;
        this.clientName = clientName;
        this.destination = destination;
        this.paymentByCard = paymentByCard;
    }

    public Ride() {

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ride ride = (Ride) o;
        return paymentByCard == ride.paymentByCard &&
                Objects.equals(id, ride.id) &&
                Objects.equals(driverId, ride.driverId) &&
                Objects.equals(clientName, ride.clientName) &&
                Objects.equals(destination, ride.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, driverId, clientName, destination, paymentByCard);
    }

    @Override
    public String toString() {
        return "Ride{" +
                "id=" + id +
                ", driverId=" + driverId +
                ", clientName='" + clientName + '\'' +
                ", destination='" + destination + '\'' +
                ", paymentByCard=" + paymentByCard +
                '}';
    }
}





