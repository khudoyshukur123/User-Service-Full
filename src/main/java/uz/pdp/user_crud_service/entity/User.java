package uz.pdp.user_crud_service.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;


@Entity
@Setter
@Getter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,name = "firstname")
    private String firstName;

    @Column(nullable = false,name = "lastname")
    private String lastName;

    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#.$^&*()_=]).{8,25}$")
    private String password;
}
