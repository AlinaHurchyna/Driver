package alina.hurchyna.ah.driver.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientController {

    @GetMapping("/client/login")
    public String clientLogin() {
        return "client_login";
    }
}
