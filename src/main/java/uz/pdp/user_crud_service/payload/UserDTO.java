package uz.pdp.user_crud_service.payload;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO implements Serializable {

    Integer id;

    @NotBlank
    String firstName;

    @NotBlank
    String lastName;

    @NotNull
    @Email
    String email;

    @NotBlank
    String password;
}