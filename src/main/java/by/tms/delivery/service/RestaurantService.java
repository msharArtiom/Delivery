package by.tms.delivery.service;

import by.tms.delivery.entity.restaurant.Restaurant;
import by.tms.delivery.exception.NotFoundException;
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

    public Restaurant save(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

    public Optional<Restaurant> findByName(String name) {

        if (!restaurantRepository.findByName(name).isPresent()) {
            throw new NotFoundException("There isn't restaurant by this name : " + name);
        }
        return restaurantRepository.findByName(name);
    }

    public Optional<Restaurant> findById(Long id) {
        if (!restaurantRepository.findById(id).isPresent()) {
            throw new NotFoundException("There isn't restaurant by this id : " + id);
        }
        return restaurantRepository.findById(id);
    }

    public Optional<Restaurant> update(Long id){
        if (!restaurantRepository.findById(id).isPresent()) {
            throw new NotFoundException("There isn't restaurant by this id : " + id);
        }
        return restaurantRepository.updateById(id);

    }
    public void delete(Long id) {
        restaurantRepository.deleteById(id);
    }
}
