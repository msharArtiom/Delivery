package by.tms.delivery.repository;

import by.tms.delivery.entity.restaurant.MenuItem;
import by.tms.delivery.entity.restaurant.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {

    Optional<MenuItem> findByName(String name);
    @Query("from MenuItem m where m.restaurant.id = :id")
    List<MenuItem> findAllMenu(Long id);
}
