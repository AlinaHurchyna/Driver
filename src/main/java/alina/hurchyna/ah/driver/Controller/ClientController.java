package alina.hurchyna.ah.driver.Controller;

import alina.hurchyna.ah.driver.Service.ClientLoginForm;
import alina.hurchyna.ah.driver.Service.ClientRegistrationForm;
import alina.hurchyna.ah.driver.Service.RideBookingForm;
import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client")
public class ClientController {

    @GetMapping("/register")
    public String showClientRegisterForm(Model model) {
        return "client_register";
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
    public String showClientDashboard(Model model) {
        return "client_dashboard";
    }

    @GetMapping("/book-ride")
    public String showBookRideForm(Model model) {
        return "book_ride";
    }

    @PostMapping("/book-ride")
    public String processRideBooking(@ModelAttribute RideBookingForm form) {
        return "redirect:/client/dashboard";
    }

    @GetMapping("/ride-history")
    public String showRideHistory(Model model) {
        return "ride_history";
    }

    public LocationUpdate trackDriver(@DestinationVariable String driverUsername) {
        // Tutaj możesz dodać logikę obsługi śledzenia kierowcy przez klienta
        return new LocationUpdate(0.0, 0.0); // Domyślna lokalizacja
    }
}
