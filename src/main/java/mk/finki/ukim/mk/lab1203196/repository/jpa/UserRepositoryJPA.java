package mk.finki.ukim.mk.lab1203196.repository.jpa;

import mk.finki.ukim.mk.lab1203196.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositoryJPA extends JpaRepository<User,Long> {
    Optional<User> findUserByUsername(String username);
}
