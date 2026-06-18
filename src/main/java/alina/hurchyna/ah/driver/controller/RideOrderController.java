package alina.hurchyna.ah.driver.controller;

import alina.hurchyna.ah.driver.service.RideOrderService;
import alina.hurchyna.ah.driver.model.RideOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ride-orders")
public class RideOrderController {

    private final RideOrderService rideOrderService;


    public RideOrderController(RideOrderService rideOrderService) {
        this.rideOrderService = rideOrderService;
    }


    @PostMapping("/reject/{orderId}")
    public ResponseEntity<String> rejectRideOrder(@PathVariable Long orderId) {

        RideOrder rideOrder = rideOrderService.getRideOrderById(orderId);

        if (rideOrder == null) {
            return ResponseEntity.status(404).body("Zamówienie o ID " + orderId + " nie istnieje");
        }


        rideOrder.setStatus("Rejected");
        rideOrderService.saveRideOrder(rideOrder);


        String responseMessage = "Zamówienie przejazdu o ID " + orderId + " zostało odrzucone";


        return ResponseEntity.ok(responseMessage);

    }
}
