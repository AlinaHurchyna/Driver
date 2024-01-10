package alina.hurchyna.ah.driver.repository;

import alina.hurchyna.ah.driver.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class ClientRepository implements JpaRepository<Client, Long> {

    public abstract Client findByUsername(String username);

    public abstract Client findByUsernameAndPassword(String username, String password);

    public abstract List<Client> findByFirstName(String firstName);

    public abstract List<Client> findByUsernameContaining(String partialUsername);

}
