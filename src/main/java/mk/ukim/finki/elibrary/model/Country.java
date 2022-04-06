package mk.ukim.finki.elibrary.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String continent;


    public Country(String name, String continent) {
        this.name = name;
        this.continent = continent;
    }

    public Country() {
    }
}
