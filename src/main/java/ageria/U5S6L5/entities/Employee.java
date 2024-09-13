package ageria.U5S6L5.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Employee {

    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String name;
    private String surname;
    private String email;
    private String avatar;


    public Employee(String username, String name, String surname, String email, String avatar) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.avatar = avatar;
    }
}
