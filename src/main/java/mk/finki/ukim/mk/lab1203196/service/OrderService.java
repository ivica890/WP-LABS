package mk.finki.ukim.mk.lab1203196.service;

import mk.finki.ukim.mk.lab1203196.model.Order;

public interface OrderService {
    Order placeOrder(String balloonColor, String clientName, String address);
}
