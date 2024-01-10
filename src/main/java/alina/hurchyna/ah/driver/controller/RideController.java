package alina.hurchyna.ah.driver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@SuppressWarnings("ALL")
@Controller
public class RideController {

    @GetMapping("/order")
    public String orderRideForm(Model model) {

        return "order_Ride";
    }

    @PostMapping("/order")
    public String orderRide() {

        return "redirect:/dashboard";
    }
}
