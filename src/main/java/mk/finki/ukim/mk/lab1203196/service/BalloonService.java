package mk.finki.ukim.mk.lab1203196.service;

import mk.finki.ukim.mk.lab1203196.model.Balloon;

import java.util.List;

public interface BalloonService {
    List<Balloon> listAll();
    List<Balloon> searchByNameOrDescription(String text);
}
