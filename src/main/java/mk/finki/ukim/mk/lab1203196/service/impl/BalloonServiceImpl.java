package mk.finki.ukim.mk.lab1203196.service.impl;

import mk.finki.ukim.mk.lab1203196.model.Balloon;
import mk.finki.ukim.mk.lab1203196.model.Manufacturer;
import mk.finki.ukim.mk.lab1203196.repository.BalloonRepository;
import mk.finki.ukim.mk.lab1203196.repository.ManufacturerRepository;
import mk.finki.ukim.mk.lab1203196.service.BalloonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BalloonServiceImpl implements BalloonService {

    private final BalloonRepository balloonRepository;
    private final ManufacturerRepository manufacturerRepository;

    public BalloonServiceImpl(BalloonRepository balloonRepository, ManufacturerRepository manufacturerRepository) {
        this.balloonRepository = balloonRepository;
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Balloon> listAll() {
        return balloonRepository.findAllBalloons();
    }

    @Override
    public List<Balloon> searchByNameOrDescription(String text) {
        return balloonRepository.findAllByNameOrDescription(text);
    }

    @Override
    public Optional<Balloon> saveBalloon(Long id, String name, String description, Long manufacturerId) {
        Manufacturer manufacturer = manufacturerRepository.findById(manufacturerId).get();
        return this.balloonRepository.saveBalloon(id,name, description, manufacturer);
    }

    @Override
    public void deleteBalloon(Long id) {
        this.balloonRepository.deleteBalloon(id);
    }

    @Override
    public Optional<Balloon> findById(Long id) {
        return balloonRepository.findById(id);
    }
}
