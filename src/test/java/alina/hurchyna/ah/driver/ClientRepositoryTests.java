package alina.hurchyna.ah.driver;

import alina.hurchyna.ah.driver.model.Client;
import alina.hurchyna.ah.driver.repository.ClientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class ClientRepositoryTests {

    @Autowired
    private ClientRepository clientRepository;

    @Test
    void testFindByUsername() {
        String mockUsername = "testUser";
        Client mockClient = new Client("John", "Doe", mockUsername, "testPassword", "123456789");
        clientRepository.save(mockClient);

        Client foundClient = clientRepository.findByUsername(mockUsername);


        assertEquals(mockUsername, foundClient.getUsername());
    }

    @Test
    void testFindByUsernameAndPassword() {

        String mockUsername = "testUser";
        String mockPassword = "testPassword";
        Client mockClient = new Client("John", "Doe", mockUsername, mockPassword, "123456789");
        clientRepository.save(mockClient);


        Client foundClient = clientRepository.findByUsernameAndPassword(mockUsername, mockPassword);


        assertEquals(mockUsername, foundClient.getUsername());
        assertEquals(mockPassword, foundClient.getPassword());
    }

    @Test
    void testFindByFirstName() {

        String mockFirstName = "John";
        Client mockClient = new Client(mockFirstName, "Doe", "testUser", "testPassword", "123456789");
        clientRepository.save(mockClient);


        List<Client> foundClients = clientRepository.findByFirstName(mockFirstName);


        assertEquals(1, foundClients.size());
        assertEquals(mockFirstName, foundClients.get(0).getFirstName());
    }

    @Test
    void testFindByUsernameContaining() {

        String partialUsername = "estUs";
        Client mockClient = new Client("John", "Doe", "testUser", "testPassword", "123456789");
        clientRepository.save(mockClient);


        List<Client> foundClients = clientRepository.findByUsernameContaining(partialUsername);


        assertEquals(1, foundClients.size());
        assertEquals("testUser", foundClients.get(0).getUsername());
    }
}
