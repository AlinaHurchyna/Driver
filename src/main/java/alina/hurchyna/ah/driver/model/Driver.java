package alina.hurchyna.ah.driver.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import java.util.Objects;

@Setter
@Getter
@Entity
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private boolean available;

    @OneToOne
    private RideOrder currentRideOrder;

    public Driver() {
    }

    public Driver(String firstName, String lastName, String username, String password, boolean available) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.available = available;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return available == driver.available && Objects.equals(id, driver.id) && Objects.equals(firstName, driver.firstName) && Objects.equals(lastName, driver.lastName) && Objects.equals(username, driver.username) && Objects.equals(password, driver.password) && Objects.equals(currentRideOrder, driver.currentRideOrder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, username, password, available, currentRideOrder);
    }

    @Override
    public String toString() {
        return "Driver{" + "id=" + id + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", username='" + username + '\'' + ", password='" + password + '\'' + ", available=" + available + ", currentRideOrder=" + currentRideOrder + '}';
    }
}
