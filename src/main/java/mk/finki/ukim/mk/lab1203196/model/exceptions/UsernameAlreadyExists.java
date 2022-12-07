package mk.finki.ukim.mk.lab1203196.model.exceptions;

public class UsernameAlreadyExists extends RuntimeException{
    public UsernameAlreadyExists(String username){
        super(String.format("The user with username %s already exists!", username));
    }
}
