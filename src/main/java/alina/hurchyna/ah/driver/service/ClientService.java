package alina.hurchyna.ah.driver.service;

import alina.hurchyna.ah.driver.model.Client;
import alina.hurchyna.ah.driver.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ClientService(ClientRepository clientRepository, PasswordEncoder passwordEncoder) {
        this.clientRepository = clientRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean registerClient(ClientRegistrationForm form) {
        if (clientRepository.findByUsername(form.getUsername()) != null) {
            return false;
        }
        Client client = new Client(
                form.getFirstName(),
                form.getLastName(),
                form.getUsername(),
                passwordEncoder.encode(form.getPassword()),
                form.getPhoneNumber()
        );
        clientRepository.save(client);
        return true;
    }

    public ClientRepository getClientRepository() {
        return clientRepository;
    }
}
