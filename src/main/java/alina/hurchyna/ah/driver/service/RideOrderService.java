package alina.hurchyna.ah.driver.service;


import alina.hurchyna.ah.driver.repository.RideOrderRepository;
import alina.hurchyna.ah.driver.model.RideOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RideOrderService {

    private final RideOrderRepository rideOrderRepository;

    @Autowired
    public RideOrderService(RideOrderRepository rideOrderRepository) {
        this.rideOrderRepository = rideOrderRepository;
    }

    public RideOrder getRideOrderById(Long orderId) {
        Optional<RideOrder> rideOrderOptional = rideOrderRepository.findById(orderId);
        return rideOrderOptional.orElse(null);
    }

    public void saveRideOrder(RideOrder rideOrder) {
        rideOrderRepository.save(rideOrder);
    }

    public void updateRideOrderStatus(Long orderId, String status) {
        RideOrder rideOrder = rideOrderRepository.findById(orderId).orElse(null);
        if (rideOrder != null) {
            rideOrder.setStatus(status);
            rideOrderRepository.save(rideOrder);
        }
    }

    // Other methods...
}
