package mk.finki.ukim.mk.lab1203196.web.controller;


import mk.finki.ukim.mk.lab1203196.model.exceptions.InvalidCredentialsException;
import mk.finki.ukim.mk.lab1203196.model.exceptions.PasswordDoNotMatchException;
import mk.finki.ukim.mk.lab1203196.service.AuthenticationService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final AuthenticationService authenticationService;

    public RegisterController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping
    public String getRegisterPage(@RequestParam(required = false) String error, Model model){
        if (error != null && !error.isEmpty()){
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        return "register";
    }

    @PostMapping
    public String register(@RequestParam String username,
                           @RequestParam String name,
                           @RequestParam String surname,
                           @RequestParam String password,
                           @RequestParam String repeatedPassword,
                           @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {

        try{
            this.authenticationService.register(username, password, repeatedPassword, name, surname, date);
            return "redirect:/login";
        }catch(PasswordDoNotMatchException | InvalidCredentialsException exception){
            return "redirect:/register?error=" + exception.getMessage();
        }
    }

}
