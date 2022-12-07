package mk.finki.ukim.mk.lab1203196.service;

import mk.finki.ukim.mk.lab1203196.model.User;

import java.time.LocalDate;

public interface AuthenticationService {

    User login (String username, String password);
    User register (String username, String password, String repeatPassword, String name, String surname,
                   LocalDate dateOfBirth);
}
