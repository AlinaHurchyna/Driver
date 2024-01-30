package alina.hurchyna.ah.driver.controller;

import alina.hurchyna.ah.driver.repository.DriverRepository;
import alina.hurchyna.ah.driver.model.Driver;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {

    private final DriverRepository driverRepository;
    private String driverUsername;

    @Autowired
    public DriverController(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
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
}
