package alina.hurchyna.ah.driver.Service;


import alina.hurchyna.ah.driver.Repository.RideOrderRepository;
import alina.hurchyna.ah.driver.model.RideOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RideOrderService {

    private final RideOrderRepository rideOrderRepository;

    @Autowired
    public RideOrderService(RideOrderRepository rideOrderRepository) {
        this.rideOrderRepository = rideOrderRepository;
    }

    public RideOrder placeRideOrder(RideOrder rideOrder) {
        return rideOrder;
    }
}
