package alina.hurchyna.ah.driver.service;


import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DriverLocationUpdate extends alina.hurchyna.ah.driver.model.DriverLocationUpdate {
    private Long driverId;
    private double latitude;
    private double longitude;
}
