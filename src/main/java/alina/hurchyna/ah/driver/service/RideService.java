package alina.hurchyna.ah.driver.service;


import alina.hurchyna.ah.driver.model.RideRequest;
import alina.hurchyna.ah.driver.model.RideStatus;
import alina.hurchyna.ah.driver.repository.RideRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RideService {

    private final RideRequestRepository rideRequestRepository;

    @Autowired
    public RideService(RideRequestRepository rideRequestRepository) {
        this.rideRequestRepository = rideRequestRepository;
    }

    public RideRequest acceptRide(Long rideId, String driverUsername) {
        RideRequest rideRequest = rideRequestRepository.findById(rideId).orElse(null);
        if (rideRequest != null) {
            rideRequest.setStatus(RideStatus.ACCEPTED);
            rideRequest.setDriverUsername(driverUsername);
            rideRequestRepository.save(rideRequest);
        }
        return rideRequest;
    }

    public void requestRide(RideRequest rideRequest) {
        rideRequest.setStatus(RideStatus.PENDING);
        rideRequest.setRideDate(LocalDateTime.now());
        rideRequestRepository.save(rideRequest);
    }

    public List<RideRequest> getAvailableRides() {
        return rideRequestRepository.findByStatus(RideStatus.PENDING);
    }

    public RideRequest getRideById(Long rideId) {
        return rideRequestRepository.findById(rideId).orElse(null);
    }

    public List<RideRequest> getRidesByDriver(String driverUsername) {
        return rideRequestRepository.findByDriverUsernameAndStatusOrderByIdDesc(driverUsername, RideStatus.COMPLETED);
    }

    public List<RideRequest> getRidesByClient(String clientUsername) {
        return rideRequestRepository.findByClientUsernameOrderByIdDesc(clientUsername);
    }

    public RideRequest clientOnboard(Long rideId) {
        RideRequest rideRequest = rideRequestRepository.findById(rideId).orElse(null);
        if (rideRequest != null) {
            rideRequest.setStatus(RideStatus.IN_PROGRESS);
            rideRequestRepository.save(rideRequest);
        }
        return rideRequest;
    }

    public RideRequest getLatestRideForClient(String clientUsername) {
        return rideRequestRepository.findFirstByClientUsernameOrderByIdDesc(clientUsername);
    }

    public RideRequest completeRide(Long rideId) {
        RideRequest rideRequest = rideRequestRepository.findById(rideId).orElse(null);
        if (rideRequest != null) {
            rideRequest.setStatus(RideStatus.COMPLETED);
            rideRequestRepository.save(rideRequest);
        }
        return rideRequest;
    }

}
