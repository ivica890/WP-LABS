package mk.finki.ukim.mk.lab1203196.repository;

import mk.finki.ukim.mk.lab1203196.dataHolder.DataHolder;
import mk.finki.ukim.mk.lab1203196.model.Balloon;
import mk.finki.ukim.mk.lab1203196.model.Manufacturer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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

    public Optional<Balloon> saveBalloon(Long id,String name,
                                         String description,
                                         Manufacturer manufacturer){
        DataHolder.balloonList.removeIf(element-> element.getId().equals(id));
        Balloon balloon = new Balloon(name,description,manufacturer);
        DataHolder.balloonList.add(balloon);
        return Optional.of(balloon);
    }

    public Optional<Balloon> findById(Long id){
        return DataHolder.balloonList.stream()
                .filter(balloon -> balloon.getId().equals(id))
                .findFirst();
    }

    public void deleteBalloon(Long id){
        DataHolder.balloonList.removeIf(element-> element.getId().equals(id));
    }
}
