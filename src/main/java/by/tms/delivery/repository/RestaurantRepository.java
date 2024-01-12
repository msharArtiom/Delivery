package by.tms.delivery.repository;

import by.tms.delivery.entity.restaurant.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    Optional<Restaurant> findByName(String name);
    Optional<Restaurant> updateById(Long id);

}
