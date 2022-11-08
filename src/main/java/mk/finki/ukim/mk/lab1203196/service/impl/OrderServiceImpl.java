package mk.finki.ukim.mk.lab1203196.service.impl;

import mk.finki.ukim.mk.lab1203196.model.Order;
import mk.finki.ukim.mk.lab1203196.repository.OrderRepository;
import mk.finki.ukim.mk.lab1203196.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Optional<Order> save(String color,String size, String clientName, String address) {
        return orderRepository.saveOrder(color,size,clientName,address);
    }

    @Override
    public List<Order> listAll() {
        return orderRepository.listAll();
    }
}
