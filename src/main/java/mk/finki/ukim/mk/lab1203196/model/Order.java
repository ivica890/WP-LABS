package mk.finki.ukim.mk.lab1203196.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data

public class Order {

    private String balloonColor;
    private String balloonSize;
    private String clientName;
    private String clientAddress;
    private Long orderId;

    public Order(String balloonColor, String balloonSize, String clientName, String clientAddress) {
        this.balloonColor = balloonColor;
        this.balloonSize = balloonSize;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.orderId = (long)(Math.random() * 1000);
    }
}
