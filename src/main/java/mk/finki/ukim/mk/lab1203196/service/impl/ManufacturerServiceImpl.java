package mk.finki.ukim.mk.lab1203196.service.impl;

import mk.finki.ukim.mk.lab1203196.model.Manufacturer;
import mk.finki.ukim.mk.lab1203196.repository.ManufacturerRepository;
import mk.finki.ukim.mk.lab1203196.service.ManufacturerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    public final ManufacturerRepository manufacturerRepository;

    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Manufacturer> findAll() {
        List<Manufacturer> manufacturerList = manufacturerRepository.findAll();
        return manufacturerList;
    }

    @Override
    public Optional<Manufacturer> findById(Long id) {
        return manufacturerRepository.findById(id);
    }
}
