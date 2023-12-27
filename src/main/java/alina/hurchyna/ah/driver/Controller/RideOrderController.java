package alina.hurchyna.ah.driver.Controller;

import alina.hurchyna.ah.driver.Service.RideOrderService;
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

    /**
     * Obsługuje odrzucanie zamówienia przejazdu.
     *
     * @param orderId ID zamówienia przejazdu, które ma zostać odrzucone.
     * @return ResponseEntity wskazujący na powodzenie odrzucenia.
     */
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
