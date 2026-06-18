package alina.hurchyna.ah.driver.service;

import lombok.Data;

@Data
public class DriverLocationUpdate {
    private Long driverId;
    private double latitude;
    private double longitude;
}
