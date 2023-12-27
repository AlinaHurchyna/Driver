package alina.hurchyna.ah.driver.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapController {

    @GetMapping("/map")
    public String showMap() {
        return "map"; // Utwórz plik HTML o nazwie "map.html"
    }
}
