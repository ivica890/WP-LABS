package mk.finki.ukim.mk.lab1203196.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Table(name = "balloons_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

//    private String clientName;
//    private String clientAddress;
    private String balloonColor;
    private String balloonSize;
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    LocalDateTime dateCreated;

    @ManyToOne
    private ShoppingCart shoppingCart;


    public Order(String balloonColor, String balloonSize, LocalDateTime dateCreated) {
        this.balloonColor = balloonColor;
        this.balloonSize = balloonSize;
        this.dateCreated = dateCreated;
//        this.clientName = clientName;
//        this.clientAddress = clientAddress;
    }

}
