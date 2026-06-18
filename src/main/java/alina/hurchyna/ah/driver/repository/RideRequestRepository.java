package alina.hurchyna.ah.driver.repository;

import alina.hurchyna.ah.driver.model.RideRequest;
import alina.hurchyna.ah.driver.model.RideStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RideRequestRepository extends JpaRepository<RideRequest, Long> {


    List<RideRequest> findByStatus(RideStatus status);

    List<RideRequest> findByDriverUsernameAndStatus(String driverUsername, RideStatus status);

    List<RideRequest> findByDriverUsernameAndStatusOrderByIdDesc(String driverUsername, RideStatus status);

    List<RideRequest> findByDriverUsername(String driverUsername);

    RideRequest findFirstByClientUsernameOrderByIdDesc(String clientUsername);

    List<RideRequest> findByClientUsernameOrderByIdDesc(String clientUsername);
}
