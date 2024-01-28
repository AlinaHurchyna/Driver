package alina.hurchyna.ah.driver.service;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientRegistrationForm {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String confirmPassword;
    private String phoneNumber;


    public ClientRegistrationForm(String firstName, String lastName, String username, String password, String confirmPassword, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.phoneNumber = phoneNumber;
    }

}
