package alina.hurchyna.ah.driver.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private boolean available;

    public String getUsername() {
        return null;
    }

    public String getPassword() {
        return null;
    }

    public void setAvailable(boolean b) {
    }

    public boolean isAvailable() {
        return false;
    }
}

