package alina.hurchyna.ah.driver.controller;

import alina.hurchyna.ah.driver.model.RideRequest;
import alina.hurchyna.ah.driver.repository.DriverRepository;
import alina.hurchyna.ah.driver.model.Driver;
import alina.hurchyna.ah.driver.service.RideService;
import alina.hurchyna.ah.driver.service.NotificationService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {

    private final DriverRepository driverRepository;
    private final RideService rideService;
    private final NotificationService notificationService;
    private String driverUsername;

    @Autowired
    public DriverController(DriverRepository driverRepository, RideService rideService, NotificationService notificationService) {
        this.driverRepository = driverRepository;
        this.rideService = rideService;
        this.notificationService = notificationService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("driver");
        return "dashboard";
    }

    @GetMapping("/availability/toggle")
    public String toggleAvailability(Authentication authentication) {
        String username = authentication.name();
        Driver driver = driverRepository.findByUsername(username);
        driver.setAvailable(!driver.isAvailable());
        driverRepository.save(driver);
        return "redirect:/dashboard";
    }

    @PostMapping("/updateLocation")
    public void updateLocation(@RequestParam String driverUsername,
                               @RequestParam double ignoredLatitude,
                               @RequestParam double ignoredLongitude) {
        // Implementacja aktualizacji lokalizacji
        this.driverUsername = driverUsername;
    }

    @GetMapping("/available-rides")
    public String getAvailableRides(Model model) {
        // Pobieranie dostępnych zgłoszeń z serwisu
        List<RideRequest> availableRides = rideService.getAvailableRides();
        model.addAttribute("rides", availableRides);
        return "available_rides";
    }

    @PostMapping("/accept-ride")
    public String acceptRide(@RequestParam("rideId") Long rideId) {
        // Logika akceptacji przejazdu
        RideRequest acceptedRide = rideService.acceptRide(rideId);

        // Wysłanie powiadomienia do kierowcy
        notificationService.sendNotification("Nowe zgłoszenie przejazdu!", acceptedRide.getDriverId());

        return "redirect:/driver/accepted-rides";
    }

    // ... Pozostałe metody kontrolera
}
