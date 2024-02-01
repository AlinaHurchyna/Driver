package alina.hurchyna.ah.driver.service;


import alina.hurchyna.ah.driver.model.RideRequest;
import alina.hurchyna.ah.driver.model.RideStatus;
import alina.hurchyna.ah.driver.repository.RideRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RideService {

    private final RideRequestRepository rideRequestRepository;

    @Autowired
    public RideService(RideRequestRepository rideRequestRepository) {
        this.rideRequestRepository = rideRequestRepository;
    }

    public RideRequest acceptRide(Long rideId) {
        RideRequest rideRequest = rideRequestRepository.findById(rideId).orElse(null);
        if (rideRequest != null) {

            rideRequest.setStatus(RideStatus.ACCEPTED);
            rideRequestRepository.save(rideRequest);
        }
        return rideRequest;
    }
    public void requestRide(RideRequest rideRequest) {
        // Implement the logic to handle the ride request, such as saving it to a repository or processing it in some way.
        // For example, you can use a repository to save the ride request:
        // rideRequestRepository.save(rideRequest);
    }
    public List<RideRequest> getAvailableRides() {

        return rideRequestRepository.findByStatus(RideStatus.PENDING);
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
