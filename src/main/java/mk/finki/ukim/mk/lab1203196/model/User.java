package mk.finki.ukim.mk.lab1203196.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "balloons_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
//    private String name;
//    private String surname;
    private String password;
    @Convert(converter = UserFullnameConverter.class)
    private UserFullname userFullname;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;
    @OneToMany(mappedBy = "user")
    private List<ShoppingCart> carts;

    public User(String username, String name, String surname, String password, LocalDate dateOfBirth){
        this.username = username;
        this.userFullname = new UserFullname(name, surname);
        this.password = password;
        this.dateOfBirth = dateOfBirth;
    }
}
