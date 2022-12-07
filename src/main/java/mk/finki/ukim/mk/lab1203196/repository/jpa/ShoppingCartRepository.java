package mk.finki.ukim.mk.lab1203196.repository.jpa;

import mk.finki.ukim.mk.lab1203196.model.ShoppingCart;
import mk.finki.ukim.mk.lab1203196.model.User;
import mk.finki.ukim.mk.lab1203196.model.enumerations.ShoppingCartStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    Optional<ShoppingCart> findShoppingCartByUserAndStatus(User user, ShoppingCartStatus shoppingCartStatus);
}
