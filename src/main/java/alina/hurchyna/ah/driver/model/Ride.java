package alina.hurchyna.ah.driver.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public boolean isPaymentByCard() {
        return paymentByCard;
    }

    public void setPaymentByCard(boolean paymentByCard) {
        this.paymentByCard = paymentByCard;
    }

    // Equals, hashCode, toString

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





