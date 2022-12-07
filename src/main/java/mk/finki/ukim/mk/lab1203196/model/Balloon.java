package mk.finki.ukim.mk.lab1203196.model;

import lombok.AllArgsConstructor;
import lombok.Data;


import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
public class Balloon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @ManyToOne
    private Manufacturer manufacturer;

    public Balloon(){

    }

    public Balloon(String name, String description, Manufacturer manufacturer) {
        this.name = name;
        this.description = description;
        this.manufacturer = manufacturer;
    }

}
