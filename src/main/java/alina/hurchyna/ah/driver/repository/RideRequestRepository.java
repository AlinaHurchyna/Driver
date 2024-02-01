package alina.hurchyna.ah.driver.repository;

import alina.hurchyna.ah.driver.model.RideRequest;
import alina.hurchyna.ah.driver.model.RideStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RideRequestRepository extends JpaRepository<RideRequest, Long> {


    List<RideRequest> findByStatus(RideStatus status);


}
