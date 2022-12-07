package mk.finki.ukim.mk.lab1203196.service.impl;

import mk.finki.ukim.mk.lab1203196.model.Balloon;
import mk.finki.ukim.mk.lab1203196.model.Manufacturer;
import mk.finki.ukim.mk.lab1203196.repository.ManufacturerRepository;
import mk.finki.ukim.mk.lab1203196.repository.jpa.BalloonRepositoryJPA;
import mk.finki.ukim.mk.lab1203196.repository.jpa.ManufacturerRepositoryJPA;
import mk.finki.ukim.mk.lab1203196.service.BalloonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BalloonServiceImpl implements BalloonService {


    private final BalloonRepositoryJPA balloonRepositoryJPA;
    private final ManufacturerRepositoryJPA manufacturerRepositoryJPA;


    public BalloonServiceImpl(BalloonRepositoryJPA balloonRepositoryJPA, ManufacturerRepositoryJPA manufacturerRepositoryJPA) {

        this.balloonRepositoryJPA = balloonRepositoryJPA;
        this.manufacturerRepositoryJPA = manufacturerRepositoryJPA;

    }

    @Override
    public List<Balloon> listAll() {
        return balloonRepositoryJPA.findAll();
    }

    @Override
    public List<Balloon> searchByNameOrDescription(String name,String text) {
        return balloonRepositoryJPA.searchByNameOrDescription(name,text);
    }

    @Override
    public Optional<Balloon> saveBalloon(Long id, String name, String description, Long manufacturerId) {
        Manufacturer manufacturer = manufacturerRepositoryJPA.findById(manufacturerId).get();
        Balloon b = new Balloon(id,name, description, manufacturer);
        return Optional.of(this.balloonRepositoryJPA.save(b));
    }

    @Override
    public void deleteBalloon(Long id) {
        this.balloonRepositoryJPA.deleteById(id);
    }

    @Override
    public Optional<Balloon> findById(Long id) {
        return balloonRepositoryJPA.findById(id);
    }
}
