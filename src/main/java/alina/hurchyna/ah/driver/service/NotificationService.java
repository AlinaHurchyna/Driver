package alina.hurchyna.ah.driver.service;


import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void sendNotification(String message, Long recipientId) {
        // Tutaj dodaj logikę wysyłania powiadomienia (np. przez komunikator, e-mail, itp.)
        System.out.println("Sending notification to recipient ID " + recipientId + ": " + message);
    }
}
