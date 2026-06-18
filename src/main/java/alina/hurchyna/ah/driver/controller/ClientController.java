package alina.hurchyna.ah.driver.controller;

import alina.hurchyna.ah.driver.model.Client;
import alina.hurchyna.ah.driver.model.RideRequest;
import alina.hurchyna.ah.driver.repository.ClientRepository;
import alina.hurchyna.ah.driver.service.ClientRegistrationForm;
import alina.hurchyna.ah.driver.service.ClientService;
import alina.hurchyna.ah.driver.service.RideService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.Map;

import java.security.Principal;

@Controller
@RequestMapping("/client")
public class ClientController {

    private final RideService rideService;
    private final ClientService clientService;
    private final ClientRepository clientRepository;

    public ClientController(RideService rideService, ClientService clientService, ClientRepository clientRepository) {
        this.rideService = rideService;
        this.clientService = clientService;
        this.clientRepository = clientRepository;
    }

    @GetMapping("/register")
    public String showClientRegisterForm(Model model) {
        model.addAttribute("form", new ClientRegistrationForm());
        return "client_register";
    }

    @PostMapping("/register")
    public String processClientRegistration(@ModelAttribute("form") ClientRegistrationForm form,
                                            RedirectAttributes redirectAttributes) {
        if (!form.getPassword().equals(form.getConfirmPassword())) {
            redirectAttributes.addFlashAttribute("error", "Пароли не совпадают");
            return "redirect:/client/register";
        }
        if (!clientService.registerClient(form)) {
            redirectAttributes.addFlashAttribute("error", "Пользователь с таким логином уже существует");
            return "redirect:/client/register";
        }
        redirectAttributes.addFlashAttribute("success", "Регистрация прошла успешно! Войдите в систему.");
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showClientLoginForm() {
        return "client_login";
    }

    @GetMapping("/dashboard")
    public String showClientDashboard(Model model, Principal principal) {
        if (principal != null) {
            Client client = clientRepository.findByUsername(principal.getName());
            model.addAttribute("client", client);
        }
        return "client_dashboard";
    }

    @GetMapping("/ride-history")
    public String showRideHistory(org.springframework.ui.Model model, java.security.Principal principal) {
        var rides = principal != null
            ? rideService.getRidesByClient(principal.getName())
            : java.util.Collections.emptyList();
        model.addAttribute("rides", rides);
        return "ride_history";
    }

    @GetMapping("/ride-status")
    @ResponseBody
    public ResponseEntity<Map<String, String>> getRideStatus(Principal principal) {
        if (principal == null) return ResponseEntity.ok(Map.of("status", "NONE"));
        var ride = rideService.getLatestRideForClient(principal.getName());
        if (ride == null) return ResponseEntity.ok(Map.of("status", "NONE"));
        return ResponseEntity.ok(Map.of(
            "status", ride.getStatus().name(),
            "driverUsername", ride.getDriverUsername() != null ? ride.getDriverUsername() : ""
        ));
    }

    @PostMapping("/request-ride")
    public String requestRide(@RequestParam String startLocation,
                              @RequestParam String destination,
                              Principal principal,
                              RedirectAttributes redirectAttributes) {
        RideRequest rideRequest = new RideRequest();
        rideRequest.setStartLocation(startLocation);
        rideRequest.setDestination(destination);
        if (principal != null) rideRequest.setClientUsername(principal.getName());
        rideService.requestRide(rideRequest);
        redirectAttributes.addFlashAttribute("success", "Поездка заказана! Ожидайте водителя.");
        return "redirect:/client/dashboard";
    }
}
