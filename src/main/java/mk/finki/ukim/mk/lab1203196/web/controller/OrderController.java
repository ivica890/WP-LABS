package mk.finki.ukim.mk.lab1203196.web.controller;

import mk.finki.ukim.mk.lab1203196.model.Order;
import mk.finki.ukim.mk.lab1203196.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String getOrders(Model model){
        List<Order> orderList = orderService.listAll();
        model.addAttribute("orders", orderList);
        model.addAttribute("bodyContent", "userOrders");

        return "master-template";
    }

    @PostMapping("/newOrder")
    public String newOrder(HttpServletRequest request){
        request.getSession().setAttribute("color", null);
        request.getSession().setAttribute("size", null);
        request.getSession().setAttribute("clientName", null);
        request.getSession().setAttribute("clientAddress", null);
        return "redirect:/balloons";
    }
}
