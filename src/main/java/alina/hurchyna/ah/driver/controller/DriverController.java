package alina.hurchyna.ah.driver.controller;

import alina.hurchyna.ah.driver.model.Driver;
import alina.hurchyna.ah.driver.model.RideRequest;
import alina.hurchyna.ah.driver.repository.DriverRepository;
import alina.hurchyna.ah.driver.service.NotificationService;
import alina.hurchyna.ah.driver.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/api/drivers")
public class DriverController {

    private final DriverRepository driverRepository;
    private final RideService rideService;
    private final NotificationService notificationService;

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
    public String dashboard(Model model, Principal principal) {
        if (principal != null) {
            Driver driver = driverRepository.findByUsername(principal.getName());
            model.addAttribute("driver", driver);
        }
        return "dashboard";
    }

    @GetMapping("/availability/toggle")
    public String toggleAvailability(Principal principal) {
        Driver driver = driverRepository.findByUsername(principal.getName());
        driver.setAvailable(!driver.isAvailable());
        driverRepository.save(driver);
        return "redirect:/dashboard";
    }

    @PostMapping("/updateLocation")
    @ResponseBody
    public void updateLocation(@RequestParam String driverUsername,
                               @RequestParam double latitude,
                               @RequestParam double longitude) {
    }

    @GetMapping("/available-rides")
    public String getAvailableRides(Model model) {
        List<RideRequest> availableRides = rideService.getAvailableRides();
        model.addAttribute("rides", availableRides);
        return "available_rides";
    }

    @PostMapping("/accept-ride")
    public String acceptRide(@RequestParam("rideId") Long rideId, Principal principal) {
        String driverUsername = principal != null ? principal.getName() : "unknown";
        RideRequest acceptedRide = rideService.acceptRide(rideId, driverUsername);
        if (acceptedRide != null) {
            return "redirect:/api/drivers/navigate/" + rideId;
        }
        return "redirect:/api/drivers/available-rides";
    }

    @GetMapping("/navigate/{rideId}")
    public String navigateToClient(@PathVariable Long rideId, Model model) {
        RideRequest ride = rideService.getRideById(rideId);
        model.addAttribute("ride", ride);
        return "driver_navigate";
    }

    @PostMapping("/client-onboard/{rideId}")
    public String clientOnboard(@PathVariable Long rideId) {
        rideService.clientOnboard(rideId);
        return "redirect:/api/drivers/navigate/" + rideId;
    }

    @PostMapping("/complete-ride/{rideId}")
    public String completeRide(@PathVariable Long rideId) {
        rideService.completeRide(rideId);
        return "redirect:/api/drivers/navigate/" + rideId;
    }
}
