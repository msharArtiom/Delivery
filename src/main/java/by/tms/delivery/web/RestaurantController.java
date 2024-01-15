package by.tms.delivery.web;

import by.tms.delivery.dto.request.UpdateMenuItemDTO;
import by.tms.delivery.dto.request.UpdateRestaurantDTO;
import by.tms.delivery.entity.restaurant.MenuItem;
import by.tms.delivery.entity.restaurant.Restaurant;
import by.tms.delivery.mapper.MyMapper;
import by.tms.delivery.service.MenuItemService;
import by.tms.delivery.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;
    private final MenuItemService menuItemService;
    private final MyMapper myMapper;


    @PostMapping("/create")
    public ResponseEntity<Restaurant> createRestaurant(@Validated @RequestBody Restaurant restaurant) {
        return ResponseEntity.ok(restaurantService.save(restaurant));
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Restaurant> deleteRestaurant(@PathVariable("id") Long id) {
        Restaurant restaurant = restaurantService.findById(id).orElseThrow();
        restaurantService.delete(restaurant.getId());
        return ResponseEntity.ok().build();
    }


    @PutMapping("/{id}/update")
    public ResponseEntity<Restaurant> updateRestaurant(
            @RequestBody UpdateRestaurantDTO restaurantDTO,
            @RequestBody Restaurant restaurant) {
        restaurant = restaurantService.updateById(myMapper.mapToRestaurant(restaurantDTO));
        return ResponseEntity.ok(restaurant);
    }


    @GetMapping("/{id}/get")
    public ResponseEntity<Restaurant> getRestaurant(@PathVariable("id") Long id) {

        return ResponseEntity.ok(restaurantService.findById(id).orElseThrow());
    }

    @GetMapping("/menu")
    public ResponseEntity<List<MenuItem>> getAllMenu(@RequestBody Restaurant restaurant) {

        return ResponseEntity.ok(restaurantService.findAllMenu(restaurant));
    }

    @PutMapping("/{id}/menu/update")
    public ResponseEntity<MenuItem> updateMenu(@RequestBody UpdateMenuItemDTO menuItemDTO,
                                               @RequestBody MenuItem menuItem) {
        menuItem = menuItemService.updateById(myMapper.mapToMenuItem(menuItemDTO));

        return ResponseEntity.ok(menuItem);
    }
    @PostMapping("/create-menu")
    public ResponseEntity<MenuItem> createMenuItem(@Validated @RequestBody MenuItem menuItem) {
        return ResponseEntity.ok(menuItemService.save(menuItem));
    }

    @DeleteMapping("/menuitem/{id}/delete")
    public ResponseEntity<MenuItem> deleteMenuItem(@PathVariable("id") Long id) {
        MenuItem menuItem = menuItemService.findById(id).orElseThrow();
        menuItemService.delete(menuItem.getId());
        return ResponseEntity.ok().build();
    }

}
