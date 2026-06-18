package alina.hurchyna.ah.driver.service;


import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void sendNotification(String message, Long recipientId) {
        System.out.println("Sending notification to recipient ID " + recipientId + ": " + message);
    }
}
