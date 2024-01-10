package alina.hurchyna.ah.driver.model;


import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
public class DriverLocationUpdate {
    private Long driverId;
    private double latitude;
    private double longitude;



    public DriverLocationUpdate() {
    }

    public DriverLocationUpdate(Long driverId, double latitude, double longitude) {
        this.driverId = driverId;
        this.latitude = latitude;
        this.longitude = longitude;
    }


    // hashCode, equals, toString

    @Override
    public int hashCode() {
        return Objects.hash(driverId, latitude, longitude);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        DriverLocationUpdate that = (DriverLocationUpdate) obj;
        return Double.compare(that.latitude, latitude) == 0 &&
                Double.compare(that.longitude, longitude) == 0 &&
                Objects.equals(driverId, that.driverId);
    }

    @Override
    public String toString() {
        return "DriverLocationUpdate{" +
                "driverId=" + driverId +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
