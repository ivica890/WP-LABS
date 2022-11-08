package mk.finki.ukim.mk.lab1203196.web.controller;

import mk.finki.ukim.mk.lab1203196.model.Balloon;
import mk.finki.ukim.mk.lab1203196.model.Manufacturer;
import mk.finki.ukim.mk.lab1203196.service.BalloonService;
import mk.finki.ukim.mk.lab1203196.service.ManufacturerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/balloons")
public class BalloonController {

    private final BalloonService balloonService;
    private final ManufacturerService manufacturerService;

    public BalloonController(BalloonService balloonService, ManufacturerService manufacturerService) {
        this.balloonService = balloonService;
        this.manufacturerService = manufacturerService;
    }

    @GetMapping
    public String getAllBalloons(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        model.addAttribute("balloons", balloonService.listAll());
        return "listBalloons";
    }


    @PostMapping
    public String saveBalloonColor(HttpServletRequest request,
                                   @RequestParam(required = false) String color) {
        request.getSession().setAttribute("color", color);
        return "redirect:/selectBalloon";
    }

    @GetMapping("/add")
    public String getAddForm(Model model) {
        List<Manufacturer> manufacturerList = manufacturerService.findAll();
        model.addAttribute("manufacturers", manufacturerList);
        return "add-balloon";
    }


    @DeleteMapping("/delete/{id}")
    public String deleteBalloon(@PathVariable Long id) {
        this.balloonService.deleteBalloon(id);
        return "redirect:/balloons";
    }

    @GetMapping("edit/{id}")
    public String editBalloonPage(@PathVariable Long id,
                                  Model model) {
        if (this.balloonService.findById(id).isPresent()) {
            Balloon balloon = this.balloonService.findById(id).get();
            List<Manufacturer> manufacturerList = this.manufacturerService.findAll();
            model.addAttribute("balloon", balloon);
            model.addAttribute("manufacturers", manufacturerList);
            return "add-balloon";
        }
        return "redirect:/balloons?error=Balloon%20Not%20Found";
    }

    @PostMapping("/add")

    public String saveNewBalloon(@RequestParam(required = false) Long id,
                                 @RequestParam String name,
                                 @RequestParam String description,
                                 @RequestParam Long manufacturerId) {
        this.balloonService.saveBalloon(id, name, description, manufacturerId);
        return "redirect:/balloons";
    }


}
