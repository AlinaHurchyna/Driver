package alina.hurchyna.ah.driver.service;

public class RideBookingForm {

    private String clientName;
    private String destination;
    private boolean paymentByCard;

    public RideBookingForm(String clientName, String destination, boolean paymentByCard) {
        this.clientName = clientName;
        this.destination = destination;
        this.paymentByCard = paymentByCard;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public boolean isPaymentByCard() {
        return paymentByCard;
    }

    public void setPaymentByCard(boolean paymentByCard) {
        this.paymentByCard = paymentByCard;
    }
}
