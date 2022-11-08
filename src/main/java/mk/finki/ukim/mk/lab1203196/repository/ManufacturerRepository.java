package mk.finki.ukim.mk.lab1203196.repository;

import mk.finki.ukim.mk.lab1203196.dataHolder.DataHolder;
import mk.finki.ukim.mk.lab1203196.model.Manufacturer;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Repository
public class ManufacturerRepository {

    public List<Manufacturer> findAll(){
      return DataHolder.manufacturerList;
    }

    public Optional<Manufacturer> findById(Long id) {
        return DataHolder.manufacturerList.stream().
                filter(element -> element.getId().equals(id))
                .findFirst();
    }
}
