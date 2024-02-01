package alina.hurchyna.ah.driver.service;


import alina.hurchyna.ah.driver.model.Driver;
import alina.hurchyna.ah.driver.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DriverService {

    private final DriverRepository driverRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public DriverService(DriverRepository driverRepository, PasswordEncoder passwordEncoder) {
        this.driverRepository = driverRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean registerDriver(DriverRegistrationDTO driverDTO) {
        Driver driver = new Driver();
        driver.setEmail(driverDTO.getEmail());
        driver.setPassword(passwordEncoder.encode(driverDTO.getPassword()));

        // Save the driver to the repository
        driverRepository.save(driver);

        return true; // Registration success
    }
}

