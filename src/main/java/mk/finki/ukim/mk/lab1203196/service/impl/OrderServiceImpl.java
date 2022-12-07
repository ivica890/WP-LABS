package mk.finki.ukim.mk.lab1203196.service.impl;

import mk.finki.ukim.mk.lab1203196.model.Order;
import mk.finki.ukim.mk.lab1203196.model.User;
import mk.finki.ukim.mk.lab1203196.repository.OrderRepository;
import mk.finki.ukim.mk.lab1203196.repository.jpa.OrderRepositoryJPA;
import mk.finki.ukim.mk.lab1203196.service.OrderService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {


    private final OrderRepositoryJPA orderRepositoryJPA;

    public OrderServiceImpl(OrderRepositoryJPA orderRepositoryJPA) {

        this.orderRepositoryJPA = orderRepositoryJPA;
    }

    @Override
    public Optional<Order> save(String color, String size, LocalDateTime dateCreated) {

        Order o = new Order(color,size,dateCreated);
        return Optional.of(orderRepositoryJPA.save(o));
    }

    @Override
    public List<Order> listAll() {
        return orderRepositoryJPA.findAll();
    }
}
