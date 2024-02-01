package alina.hurchyna.ah.driver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class MyController {

    @GetMapping("/home")
    public String home() {
        return "home"; // Zakładam, że masz plik widoku o nazwie "home.jsp" w katalogu "/WEB-INF/views/"
    }
}
