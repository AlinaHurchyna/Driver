package alina.hurchyna.ah.driver.controller;

import alina.hurchyna.ah.driver.model.RideRequest;
import alina.hurchyna.ah.driver.service.ClientLoginForm;
import alina.hurchyna.ah.driver.service.ClientRegistrationForm;
import alina.hurchyna.ah.driver.service.RideBookingForm;
import alina.hurchyna.ah.driver.service.RideService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/client")
public class ClientController {

    private final RideService rideService;

    public ClientController(RideService rideService) {
        this.rideService = rideService;
    }

    @GetMapping("/register")
    public String showClientRegisterForm() {
        return "redirect:/client/register";
    }

    @PostMapping("/register")
    public String processClientRegistration(@ModelAttribute ClientRegistrationForm form) {
        return "redirect:/client/login";
    }

    @GetMapping("/login")
    public String showClientLoginForm() {
        return "client_login";
    }

    @PostMapping("/login")
    public String processClientLogin(@ModelAttribute ClientLoginForm form) {
        return "redirect:/client/dashboard";
    }

    @GetMapping("/dashboard")
    public String showClientDashboard() {
        return "client_dashboard";
    }

    @GetMapping("/book-ride")
    public String showBookRideForm() {
        return "book_ride";
    }

    @PostMapping("/book-ride")
    public String processRideBooking(@ModelAttribute RideBookingForm form) {
        return "redirect:/client/dashboard";
    }

    @GetMapping("/ride-history")
    public String showRideHistory() {
        return "ride_history";
    }

    @PostMapping("/request-ride")
    public String requestRide(@RequestParam String startLocation,
                              @RequestParam String destination) {

        RideRequest rideRequest = new RideRequest();
        rideRequest.setStartLocation(startLocation);
        rideRequest.setDestination(destination);

        rideService.requestRide(rideRequest);

        return "redirect:/client/available-rides";
    }
}

