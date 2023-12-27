package alina.hurchyna.ah.driver.Repository;

import alina.hurchyna.ah.driver.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByUsername(String username);
}
