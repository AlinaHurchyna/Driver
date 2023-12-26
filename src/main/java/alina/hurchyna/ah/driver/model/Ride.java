package alina.hurchyna.ah.driver.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public record Ride(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,
        String origin,
        String destination,
        LocalDateTime startTime,
        LocalDateTime endTime,
        Long driverId,
        Long clientId
) {
    // Additional methods or customizations if needed


}
