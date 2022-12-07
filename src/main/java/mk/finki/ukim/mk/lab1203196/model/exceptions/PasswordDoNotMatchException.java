package mk.finki.ukim.mk.lab1203196.model.exceptions;

public class PasswordDoNotMatchException extends RuntimeException{

    public PasswordDoNotMatchException(){
        super("Passwords do not match!");
    }
}
