package alina.hurchyna.ah.driver.controller;

import alina.hurchyna.ah.driver.service.DriverRegistrationDTO;
import alina.hurchyna.ah.driver.service.DriverService;
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

    @Autowired
    public DriverAuthController(DriverService driverService) {
        this.driverService = driverService;
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

    // Pozostała logika procesu logowania...
}
