package alina.hurchyna.ah.driver.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClientController {

    @GetMapping("/client/register")
    public String clientRegisterForm() {
        return "client_register";
    }

    @PostMapping("/client/register")
    public String processClientRegistration(/* Dodaj parametry z formularza rejestracji */) {

        return "redirect:/client/login";
    }

    @GetMapping("/client/login")
    public String clientLoginForm() {
        return "client_login";
    }

    @PostMapping("/client/login")
    public String processClientLogin(/* Dodaj parametry z formularza logowania */) {

        return "redirect:/client/dashboard";
    }

    @GetMapping("/client/dashboard")
    public String clientDashboard(Model model) {

        return "client_dashboard";
    }

    @GetMapping("/client/book-ride")
    public String bookRideForm(Model model) {

        return "book_ride";
    }

    @PostMapping("/client/book-ride")
    public String processRideBooking(/* Dodaj parametry z formularza zamówienia przejazdu */) {

        return "redirect:/client/dashboard";
    }

    @GetMapping("/client/ride-history")
    public String rideHistory(Model model) {
        return "ride_history";
    }
}
