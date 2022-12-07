package mk.finki.ukim.mk.lab1203196.service.impl;


import mk.finki.ukim.mk.lab1203196.model.User;
import mk.finki.ukim.mk.lab1203196.model.exceptions.InvalidCredentialsException;
import mk.finki.ukim.mk.lab1203196.model.exceptions.InvalidUserCredentialsException;
import mk.finki.ukim.mk.lab1203196.model.exceptions.PasswordDoNotMatchException;
import mk.finki.ukim.mk.lab1203196.model.exceptions.UsernameAlreadyExists;
import mk.finki.ukim.mk.lab1203196.repository.jpa.UserRepositoryJPA;
import mk.finki.ukim.mk.lab1203196.service.AuthenticationService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepositoryJPA userRepository;

    public AuthenticationServiceImpl(UserRepositoryJPA userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()){
            throw new InvalidCredentialsException();
        }
        return this.userRepository.findUserByUsername(username).orElseThrow(InvalidUserCredentialsException::new);
    }

    @Override
    public User register(String username, String password, String repeatPassword, String name, String surname, LocalDate dateOfBirth) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()){
            throw new InvalidCredentialsException();
        }
        if (!password.equals(repeatPassword)){
            throw new PasswordDoNotMatchException();
        }
        if(this.userRepository.findUserByUsername(username).isPresent() || !this.userRepository.findUserByUsername(username).isEmpty()){
            throw new UsernameAlreadyExists(username);
        }

        User user = new User(username, name, surname, password, dateOfBirth);
        return userRepository.save(user);
    }
}
