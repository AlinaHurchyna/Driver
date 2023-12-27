package alina.hurchyna.ah.driver.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long driverId;
    private String clientName;
    private String destination;
    private boolean paymentByCard;
}







