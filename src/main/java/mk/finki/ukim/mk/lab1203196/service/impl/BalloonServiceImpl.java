package mk.finki.ukim.mk.lab1203196.service.impl;

import mk.finki.ukim.mk.lab1203196.model.Balloon;
import mk.finki.ukim.mk.lab1203196.repository.BalloonRepository;
import mk.finki.ukim.mk.lab1203196.service.BalloonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BalloonServiceImpl implements BalloonService {

    @Autowired
    private BalloonRepository balloonRepository;

    @Override
    public List<Balloon> listAll() {
        return balloonRepository.findAllBalloons();
    }

    @Override
    public List<Balloon> searchByNameOrDescription(String text) {
        return balloonRepository.findAllByNameOrDescription(text);
    }
}
