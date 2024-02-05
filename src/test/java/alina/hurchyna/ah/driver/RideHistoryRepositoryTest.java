package alina.hurchyna.ah.driver;

import alina.hurchyna.ah.driver.model.RideHistory;
import alina.hurchyna.ah.driver.repository.RideHistoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class RideHistoryRepositoryTest {

    @Autowired
    private RideHistoryRepository rideHistoryRepository;

    @Test
    void testSaveAndFindById() {
        // Prepare test data
        RideHistory rideHistory = new RideHistory(1L, 101L, LocalDateTime.now(), true);

        // Save to repository
        rideHistoryRepository.save(rideHistory);

        // Find by id
        RideHistory foundRideHistory = rideHistoryRepository.findById(rideHistory.getId()).orElse(null);

        // Assertions
        assertEquals(rideHistory, foundRideHistory);
    }
}
