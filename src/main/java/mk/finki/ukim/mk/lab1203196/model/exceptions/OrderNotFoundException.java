package mk.finki.ukim.mk.lab1203196.model.exceptions;

public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException(){
        super(String.format("The order was not found!"));
    }
}
