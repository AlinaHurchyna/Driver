package alina_hurchyna_ah.driver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class MyController {

    @GetMapping
    public String home() {
        return "Welcome to the home page!";
    }
}
