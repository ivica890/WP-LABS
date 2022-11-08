package mk.finki.ukim.mk.lab1203196.service;

import mk.finki.ukim.mk.lab1203196.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Optional <Order> save(String color,String size, String clientName, String address);
    public List<Order> listAll();
}
