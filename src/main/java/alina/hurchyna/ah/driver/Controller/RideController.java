package alina.hurchyna.ah.driver.Controller;

import alina.hurchyna.ah.driver.model.Ride;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RideController {

    @GetMapping("/order")
    public String orderRideForm(Model model) {
        // Wyświetl formularz zamawiania przejazdu
        return "order_ride";
    }

    @PostMapping("/order")
    public String orderRide(Ride ride) {
        // Zapisz zamówienie przejazdu do bazy danych
        return "redirect:/dashboard";
    }
}
