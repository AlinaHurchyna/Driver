package alina.hurchyna.ah.driver.service;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RideBookingForm {

    private String clientName;
    private String destination;
    private boolean paymentByCard;

    public RideBookingForm(String clientName, String destination, boolean paymentByCard) {
        this.clientName = clientName;
        this.destination = destination;
        this.paymentByCard = paymentByCard;
    }

}
