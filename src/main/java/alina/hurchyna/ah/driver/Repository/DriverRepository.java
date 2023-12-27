package alina.hurchyna.ah.driver.Repository;

import alina.hurchyna.ah.driver.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {

    Driver findByUsername(String username);
}