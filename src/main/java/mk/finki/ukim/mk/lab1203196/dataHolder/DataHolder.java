package mk.finki.ukim.mk.lab1203196.dataHolder;

import mk.finki.ukim.mk.lab1203196.model.Balloon;
import mk.finki.ukim.mk.lab1203196.model.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Balloon> balloonList = new ArrayList<>();

    @PostConstruct
    public void init(){
        balloonList.add(new Balloon("White","White Balloon"));
        balloonList.add(new Balloon("Black","Black Balloon"));
        balloonList.add(new Balloon("Red","Red Balloon"));
        balloonList.add(new Balloon("Yellow","Yellow Balloon"));
        balloonList.add(new Balloon("Orange","Orange Balloon"));
        balloonList.add(new Balloon("Green","Green Balloon"));
        balloonList.add(new Balloon("Purple","Purple Balloon"));
        balloonList.add(new Balloon("Blue","Blue Balloon"));
        balloonList.add(new Balloon("Gray","Gray Balloon"));
        balloonList.add(new Balloon("Brown","Brown Balloon"));


    }
}