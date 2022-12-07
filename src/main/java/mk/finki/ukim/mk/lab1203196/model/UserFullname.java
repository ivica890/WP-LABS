package mk.finki.ukim.mk.lab1203196.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data

public class UserFullname implements Serializable {

    private String name;
    private String surname;

    public UserFullname(String name, String surname){
        this.surname = surname;
        this.name = name;
    }
    public UserFullname(){

    }


}
