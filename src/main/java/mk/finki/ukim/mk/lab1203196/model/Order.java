package mk.finki.ukim.mk.lab1203196.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
    private String balloonColor;
    private String balloonSize;
    private String clientName;
    private String clientAddress;
    private Long orderId;
}
