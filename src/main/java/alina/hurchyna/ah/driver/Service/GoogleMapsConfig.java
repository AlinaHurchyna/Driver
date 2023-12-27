package alina.hurchyna.ah.driver.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GoogleMapsConfig {

    @Value("${google.maps.api.key}")
    private String googleMapsApiKey;

    public String getGoogleMapsApiKey() {
        return googleMapsApiKey;
    }
}
