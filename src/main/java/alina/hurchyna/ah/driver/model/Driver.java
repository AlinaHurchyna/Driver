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

    private String email; // Moved email here

    @OneToOne
    private RideOrder currentRideOrder;

    public Driver() {
        // Default constructor
    }

    // Constructor with basic fields
    public Driver(String firstName, String lastName, String username, String password, boolean available, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.available = available;
        this.email = email;
    }

    // Getters, setters, equals, hashCode, toString methods...

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return available == driver.available &&
                Objects.equals(id, driver.id) &&
                Objects.equals(firstName, driver.firstName) &&
                Objects.equals(lastName, driver.lastName) &&
                Objects.equals(username, driver.username) &&
                Objects.equals(password, driver.password) &&
                Objects.equals(email, driver.email) &&
                Objects.equals(currentRideOrder, driver.currentRideOrder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, username, password, available, email, currentRideOrder);
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", available=" + available +
                ", email='" + email + '\'' +
                ", currentRideOrder=" + currentRideOrder +
                '}';
    }
}
