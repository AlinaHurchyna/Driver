package alina.hurchyna.ah.driver.service;


import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class TrackingService {

    private final SimpMessagingTemplate messagingTemplate;

    public TrackingService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void updateDriverLocation(DriverLocationUpdate locationUpdate) {

        messagingTemplate.convertAndSend("/topic/driver/" + locationUpdate.getDriverId(), locationUpdate);
    }
}
