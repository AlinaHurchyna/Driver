package alina.hurchyna.ah.driver.controller;

import alina.hurchyna.ah.driver.service.DriverRegistrationDTO;
import alina.hurchyna.ah.driver.service.DriverService;
import alina.hurchyna.ah.driver.service.RideService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/driver")
public class DriverAuthController {

    private final DriverService driverService;
    private final RideService rideService;

    @Autowired
    public DriverAuthController(DriverService driverService, RideService rideService) {
        this.driverService = driverService;
        this.rideService = rideService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("driver", new DriverRegistrationDTO());
        return "driver_register";
    }

    @PostMapping("/register")
    public String processRegistration(@ModelAttribute("driver") @Valid DriverRegistrationDTO driverDTO,
                                      BindingResult result) {
        if (result.hasErrors()) {
            return "driver_register";
        }

        // Przesłanie danych do procesu uwierzytelniania i weryfikacji
        if (driverService.registerDriver(driverDTO)) {
            return "redirect:/driver/login?success";
        } else {
            result.rejectValue("email", "error.driver", "Kierowca o podanym adresie e-mail już istnieje.");
            return "driver_register";
        }
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "driver_login";
    }

    @GetMapping("/ride-history")
    public String showRideHistory(org.springframework.ui.Model model, java.security.Principal principal) {
        java.util.List<alina.hurchyna.ah.driver.model.RideRequest> rides =
            principal != null ? rideService.getRidesByDriver(principal.getName()) : java.util.Collections.emptyList();
        model.addAttribute("rides", rides);
        return "driver_ride_history";
    }

    // Pozostała logika procesu logowania...
}
