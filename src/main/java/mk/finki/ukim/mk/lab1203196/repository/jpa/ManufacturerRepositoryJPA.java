package mk.finki.ukim.mk.lab1203196.repository.jpa;

import mk.finki.ukim.mk.lab1203196.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepositoryJPA extends JpaRepository<Manufacturer, Long> {

}
