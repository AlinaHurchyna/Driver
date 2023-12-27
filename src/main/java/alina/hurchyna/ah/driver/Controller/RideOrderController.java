package alina.hurchyna.ah.driver.Controller;

import alina.hurchyna.ah.driver.Service.RideOrderService;
import alina.hurchyna.ah.driver.model.RideOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ride-orders")
public class RideOrderController {

    private final RideOrderService rideOrderService;

    @Autowired
    public RideOrderController(RideOrderService rideOrderService) {
        this.rideOrderService = rideOrderService;
    }

    @PostMapping
    public RideOrder placeRideOrder(@RequestBody RideOrder rideOrder) {
        return rideOrderService.placeRideOrder(rideOrder);
    }


}
