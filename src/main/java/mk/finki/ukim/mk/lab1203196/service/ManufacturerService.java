package mk.finki.ukim.mk.lab1203196.service;

import mk.finki.ukim.mk.lab1203196.model.Manufacturer;

import java.util.List;
import java.util.Optional;

public interface ManufacturerService {
    public List<Manufacturer> findAll();
    public Optional<Manufacturer> findById(Long id);
}
