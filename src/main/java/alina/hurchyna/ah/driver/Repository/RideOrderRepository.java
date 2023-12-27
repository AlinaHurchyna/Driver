package alina.hurchyna.ah.driver.Repository;


import alina.hurchyna.ah.driver.model.RideOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideOrderRepository extends JpaRepository<RideOrder, Long> {
  
}
