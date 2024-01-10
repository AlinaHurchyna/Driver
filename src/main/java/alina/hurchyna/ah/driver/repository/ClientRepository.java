package alina.hurchyna.ah.driver.repository;

import alina.hurchyna.ah.driver.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByUsername(String username);

    Client findByUsernameAndPassword(String username, String password);

    List<Client> findByFirstName(String firstName);

    List<Client> findByUsernameContaining(String partialUsername);

}
