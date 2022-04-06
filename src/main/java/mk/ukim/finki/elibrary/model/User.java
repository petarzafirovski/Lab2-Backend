package mk.ukim.finki.elibrary.model;

import lombok.Data;
import mk.ukim.finki.elibrary.model.enums.Role;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class User {
    @Id
    private String username;
    private String name;
    private String surname;
    private Role role;

    public User(String username, String name, String surname, Role role) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.role = role;
    }

    public User() {
    }
}
