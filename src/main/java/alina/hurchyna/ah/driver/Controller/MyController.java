package alina.hurchyna.ah.driver.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping

public class MyController {

    @GetMapping("/api/home")
    public String home() {
        return "Welcome to the home page!";
    }
}
