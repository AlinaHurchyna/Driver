package alina.hurchyna.ah.driver.Controller;

import alina.hurchyna.ah.driver.Repository.RideRepository;
import alina.hurchyna.ah.driver.model.Ride;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rides")
public class RideController {

    private final RideRepository rideRepository;

    public RideController(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }

    @GetMapping
    public List<Ride> getAllRides() {
        return rideRepository.findAll();
    }

    @GetMapping("/{id}")
    public Ride getRideById(@PathVariable Long id) {
        return rideRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ride not found with id: " + id));
    }

    @PostMapping
    public Ride createRide(@RequestBody Ride ride) {
        return rideRepository.save(ride);
    }

    @PutMapping("/{id}")
    public Ride updateRide(@PathVariable Long id, @RequestBody Ride updatedRide) {
        return rideRepository.findById(id)
                .map(ride -> {
                    ride.setStartLocation(updatedRide.getStartLocation());
                    ride.setEndLocation(updatedRide.getEndLocation());
                    return rideRepository.save(ride);
                })
                .orElseThrow(() -> new RuntimeException("Ride not found with id: " + id));
    }

    @DeleteMapping("/{id}")
    public void deleteRide(@PathVariable Long id) {
        rideRepository.deleteById(id);
    }
}
