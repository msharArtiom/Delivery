package by.tms.delivery.service;

import by.tms.delivery.entity.restaurant.MenuItem;
import by.tms.delivery.entity.restaurant.Restaurant;
import by.tms.delivery.exception.NotFoundException;
import by.tms.delivery.repository.MenuItemRepository;
import by.tms.delivery.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final MenuItemRepository menuItemRepository;

    public Restaurant save(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Transactional(readOnly = true)
    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

    public List<MenuItem> findAllMenu(Restaurant restaurant){
        return menuItemRepository.findAllMenu(restaurant.getId());
    }

    @Transactional(readOnly = true)
    public Optional<Restaurant> findByName(String name) {

        if (!restaurantRepository.findByName(name).isPresent()) {
            throw new NotFoundException("There isn't restaurant by this name : " + name);
        }
        return restaurantRepository.findByName(name);
    }

    @Transactional(readOnly = true)
    public Optional<Restaurant> findById(Long id) {
        if (!restaurantRepository.findById(id).isPresent()) {
            throw new NotFoundException("There isn't restaurant by this id : " + id);
        }
        return restaurantRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Restaurant updateById(Restaurant restaurant){
        if (!restaurantRepository.findById(restaurant.getId()).isPresent()) {
            throw new NotFoundException("There isn't restaurant by this id : " + restaurant.getId());
        }
        return restaurantRepository.save(findById(restaurant.getId()).orElseThrow());

    }
    public void delete(Long id) {
        restaurantRepository.deleteById(id);
    }
}
