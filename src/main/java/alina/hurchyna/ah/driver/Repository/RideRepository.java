package alina.hurchyna.ah.driver.Repository;


import alina.hurchyna.ah.driver.model.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideRepository extends JpaRepository<Ride, Long> {
    // Możesz dodać niestandardowe metody zapytań, jeśli są potrzebne
}
