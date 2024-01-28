package alina.hurchyna.ah.driver.service;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClientLoginForm {

    private String username;
    private String password;


    public ClientLoginForm() {
    }


    public ClientLoginForm(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
