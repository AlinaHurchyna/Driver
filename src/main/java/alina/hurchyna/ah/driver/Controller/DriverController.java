package alina.hurchyna.ah.driver.Controller;

import alina.hurchyna.ah.driver.Repository.DriverRepository;
import alina.hurchyna.ah.driver.model.Driver;
import ch.qos.logback.core.model.Model;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {

    private final DriverRepository driverRepository;

    @Autowired
    public DriverController(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }


    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboard(Authentication authentication, Model model) {
        String username = authentication.name();
        model.addText("driver");
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
                               @RequestParam double latitude,
                               @RequestParam double longitude) {

    }
}
