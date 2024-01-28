package alina.hurchyna.ah.driver.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Setter
@Getter
@Entity
public class RideOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String destination;

    public RideOrder() {
    }

    public RideOrder(String destination) {
        this.destination = destination;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RideOrder rideOrder = (RideOrder) o;
        return Objects.equals(id, rideOrder.id) && Objects.equals(destination, rideOrder.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, destination);
    }

    @Override
    public String toString() {
        return "RideOrder{" + "id=" + id + ", destination='" + destination + '\'' + '}';
    }

    public void setStatus(String status) {
    }
}
