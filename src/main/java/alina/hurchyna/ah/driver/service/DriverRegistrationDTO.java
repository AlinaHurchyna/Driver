package alina.hurchyna.ah.driver.service;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DriverRegistrationDTO {

    @NotBlank(message = "Pole nie może być puste")
    @Email(message = "Podaj poprawny adres e-mail")
    private String email;

    @NotBlank(message = "Pole nie może być puste")
    @Size(min = 8, message = "Hasło musi mieć co najmniej 8 znaków")
    private String password;

    @NotBlank(message = "Pole nie może być puste")
    private String firstName;

    @NotBlank(message = "Pole nie może być puste")
    private String lastName;
}
