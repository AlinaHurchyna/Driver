package alina.hurchyna.ah.driver.service;

import alina.hurchyna.ah.driver.model.Client;
import alina.hurchyna.ah.driver.model.Driver;
import alina.hurchyna.ah.driver.repository.ClientRepository;
import alina.hurchyna.ah.driver.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserDetailsService implements UserDetailsService {

    private final ClientRepository clientRepository;
    private final DriverRepository driverRepository;

    @Autowired
    public AppUserDetailsService(ClientRepository clientRepository, DriverRepository driverRepository) {
        this.clientRepository = clientRepository;
        this.driverRepository = driverRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client client = clientRepository.findByUsername(username);
        if (client != null) {
            return new User(client.getUsername(), client.getPassword(),
                    List.of(new SimpleGrantedAuthority("ROLE_CLIENT")));
        }

        Driver driver = driverRepository.findByUsername(username);
        if (driver != null) {
            return new User(driver.getUsername(), driver.getPassword(),
                    List.of(new SimpleGrantedAuthority("ROLE_DRIVER")));
        }

        throw new UsernameNotFoundException("User not found: " + username);
    }
}
