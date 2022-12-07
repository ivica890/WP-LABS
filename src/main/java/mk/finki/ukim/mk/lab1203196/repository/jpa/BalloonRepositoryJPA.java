package mk.finki.ukim.mk.lab1203196.repository.jpa;

import mk.finki.ukim.mk.lab1203196.model.Balloon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BalloonRepositoryJPA extends JpaRepository<Balloon, Long> {
    List<Balloon> searchByNameOrDescription(String name, String text);
    void deleteById(Long id);

}
