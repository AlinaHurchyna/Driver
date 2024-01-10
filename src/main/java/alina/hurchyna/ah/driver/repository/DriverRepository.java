package alina.hurchyna.ah.driver.repository;

import alina.hurchyna.ah.driver.model.Driver;
import alina.hurchyna.ah.driver.model.RideOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
    Driver findByCurrentRideOrder(RideOrder rideOrder);

    Driver findByUsername(String username);
}
