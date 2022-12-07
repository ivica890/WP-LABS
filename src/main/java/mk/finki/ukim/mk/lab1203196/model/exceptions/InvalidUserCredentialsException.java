package mk.finki.ukim.mk.lab1203196.model.exceptions;

public class InvalidUserCredentialsException extends RuntimeException{
    public InvalidUserCredentialsException(){
        super(String.format("The user does not exist!"));
    }
}
