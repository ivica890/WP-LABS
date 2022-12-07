package mk.finki.ukim.mk.lab1203196.model.exceptions;

public class InvalidCredentialsException extends RuntimeException{
    public InvalidCredentialsException(){
        super("Invalid arguments!");
    }
}
