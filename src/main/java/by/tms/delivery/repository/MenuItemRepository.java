package by.tms.delivery.repository;

import by.tms.delivery.entity.restaurant.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {

}
