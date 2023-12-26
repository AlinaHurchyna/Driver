package alina.hurchyna.ah.driver.Controller;

import alina.hurchyna.ah.driver.Repository.DriverRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/driver")
public class DriverController {

    private final DriverRepository driverRepository;

    public DriverController(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @GetMapping
    public String getAllDrivers(Model model) {
        model.addAttribute("drivers", driverRepository.findAll());
        return "index";
    }

    // Pozostałe metody z kontrolera
}
