package alina.hurchyna.ah.driver.Controller;


import alina.hurchyna.ah.driver.Repository.DriverRepository;
import alina.hurchyna.ah.driver.model.Driver;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DriverController {

    private final DriverRepository driverRepository;

    public DriverController(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboard(Authentication authentication, Model model) {
        String username = authentication.getName();
        Driver driver = driverRepository.findByUsername(username);
        model.addAttribute("driver", driver);
        return "dashboard";
    }

    @GetMapping("/availability/toggle")
    public String toggleAvailability(Authentication authentication) {
        String username = authentication.getName();
        Driver driver = driverRepository.findByUsername(username);
        driver.setAvailable(!driver.isAvailable());
        driverRepository.save(driver);
        return "redirect:/dashboard";
    }
}
