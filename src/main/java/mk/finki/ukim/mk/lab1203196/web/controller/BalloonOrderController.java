package mk.finki.ukim.mk.lab1203196.web.controller;

import mk.finki.ukim.mk.lab1203196.service.OrderService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/BalloonOrder.do")
public class BalloonOrderController {
   private final OrderService orderService;

    public BalloonOrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping()
    public String getDeliveryInfo(Model model){
        model.addAttribute("bodyContent","deliveryInfo");
        return "master-template";
    }

    @PostMapping()
    public String saveDeliveryInfo(HttpServletRequest req,
                                   Model model){
        String color = (String) req.getSession().getAttribute("color");
        String size = (String) req.getSession().getAttribute("size");
        LocalDateTime dateCreated = LocalDateTime.parse(req.getParameter("dateCreated"));
        orderService.save(color,size, dateCreated);
        model.addAttribute("bodyContent", "ConfirmationInfo");
        return "master-template";
    }
}


