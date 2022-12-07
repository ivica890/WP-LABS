package mk.finki.ukim.mk.lab1203196.service;

import mk.finki.ukim.mk.lab1203196.model.Balloon;
import mk.finki.ukim.mk.lab1203196.model.Manufacturer;

import java.util.List;
import java.util.Optional;

public interface BalloonService {
    List<Balloon> listAll();
    List<Balloon> searchByNameOrDescription(String name,String text);

    public Optional<Balloon> saveBalloon(Long id,String name,
                                         String description,
                                         Long manufacturerId);
    public void deleteBalloon(Long id);
    public Optional<Balloon> findById(Long id);
}
