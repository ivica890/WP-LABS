package mk.finki.ukim.mk.lab1203196.repository;

import mk.finki.ukim.mk.lab1203196.dataHolder.DataHolder;
import mk.finki.ukim.mk.lab1203196.model.Balloon;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BalloonRepository {
    public List<Balloon> findAllBalloons(){
        return DataHolder.balloonList;
    }

    public List<Balloon> findAllByNameOrDescription(String text){
        return DataHolder.balloonList.stream()
                .filter(balloon -> balloon.getName().equals(text) ||
                        balloon.getDescription().equals(text))
                .toList();
    }
}
