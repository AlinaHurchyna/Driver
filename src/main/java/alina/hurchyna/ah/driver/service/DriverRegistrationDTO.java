package alina.hurchyna.ah.driver.service;

import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.Objects;

public class DriverRegistrationDTO {

    @Getter
    @NotBlank(message = "Pole nie może być puste")
    @Email(message = "Podaj poprawny adres e-mail")
    private String email;

    @Getter
    @NotBlank(message = "Pole nie może być puste")
    @Size(min = 8, message = "Hasło musi mieć co najmniej 8 znaków")
    private  String password;

    @NotBlank(message = "Pole nie może być puste")
    private String firstName;

    @NotBlank(message = "Pole nie może być puste")
    private String lastName;




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DriverRegistrationDTO that = (DriverRegistrationDTO) o;
        return Objects.equals(email, that.email) &&
                Objects.equals(password, that.password) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password, firstName, lastName);
    }


    @Override
    public String toString() {
        return "DriverRegistrationDTO{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                // Dodatkowe pola w toString()
                '}';
    }

}
