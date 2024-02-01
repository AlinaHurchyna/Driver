package alina.hurchyna.ah.driver.controller;


import alina.hurchyna.ah.driver.model.RideRequest;
import alina.hurchyna.ah.driver.repository.RideRequestRepository;
import alina.hurchyna.ah.driver.model.RideStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rides")
public class RideRequestController {

    private final RideRequestRepository rideRequestRepository;

    @Autowired
    public RideRequestController(RideRequestRepository rideRequestRepository) {
        this.rideRequestRepository = rideRequestRepository;
    }

    @GetMapping("/available")
    public List<RideRequest> getAvailableRides() {
        // Pobieranie dostępnych zgłoszeń
        return rideRequestRepository.findByStatus(RideStatus.AVAILABLE);
    }

    @PostMapping("/accept")
    public void acceptRide(@RequestParam Long rideId) {
        // Akceptacja zgłoszenia przejazdu
        RideRequest rideRequest = rideRequestRepository.findById(rideId).orElse(null);
        if (rideRequest != null) {
            rideRequest.setStatus(RideStatus.IN_PROGRESS);
            rideRequestRepository.save(rideRequest);
        }
        // Dodatkowe logiki związane z akceptacją przejazdu
    }

    // Inne metody związane z obsługą zgłoszeń przejazdów
}
