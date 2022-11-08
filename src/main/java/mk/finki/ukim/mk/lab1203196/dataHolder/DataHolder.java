package mk.finki.ukim.mk.lab1203196.dataHolder;

import mk.finki.ukim.mk.lab1203196.model.Balloon;
import mk.finki.ukim.mk.lab1203196.model.Manufacturer;
import mk.finki.ukim.mk.lab1203196.model.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Balloon> balloonList = new ArrayList<>();
    public static List<Manufacturer> manufacturerList = new ArrayList<>();

    public static List<Order> orderList = new ArrayList<>();

    @PostConstruct
    public void init(){
        Manufacturer manufacturer1 = new Manufacturer("BT","Macedinia","address1");
        manufacturerList.add(manufacturer1);
        Manufacturer manufacturer2 = new Manufacturer("SK","Macedinia","address2");
        manufacturerList.add(manufacturer2);
        Manufacturer manufacturer3 = new Manufacturer("OH","Macedinia","address3");
        manufacturerList.add(manufacturer3);
        Manufacturer manufacturer4 = new Manufacturer("PP","Macedinia","address4");
        manufacturerList.add(manufacturer4);
        Manufacturer manufacturer5 = new Manufacturer("SR","Macedinia","address5");
        manufacturerList.add(manufacturer5);

        balloonList.add(new Balloon("White","White Balloon",manufacturer1));
        balloonList.add(new Balloon("Black","Black Balloon",manufacturer2));
        balloonList.add(new Balloon("Red","Red Balloon",manufacturer3));
        balloonList.add(new Balloon("Yellow","Yellow Balloon",manufacturer4));
        balloonList.add(new Balloon("Orange","Orange Balloon",manufacturer5));
        balloonList.add(new Balloon("Green","Green Balloon",manufacturer1));
        balloonList.add(new Balloon("Purple","Purple Balloon",manufacturer2));
        balloonList.add(new Balloon("Blue","Blue Balloon",manufacturer3));
        balloonList.add(new Balloon("Gray","Gray Balloon",manufacturer4));
        balloonList.add(new Balloon("Brown","Brown Balloon",manufacturer5));


    }
}