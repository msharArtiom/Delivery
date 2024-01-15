package by.tms.delivery.mapper;


import by.tms.delivery.dto.request.UpdateMenuItemDTO;
import by.tms.delivery.dto.request.UpdateRestaurantDTO;
import by.tms.delivery.dto.request.UpdateUserDTO;
import by.tms.delivery.entity.restaurant.MenuItem;
import by.tms.delivery.entity.restaurant.Restaurant;
import by.tms.delivery.entity.user.User;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface MyMapper {

    User mapToUser(UpdateUserDTO updateUserDTO);

    Restaurant mapToRestaurant(UpdateRestaurantDTO updateRestaurantDTO);


    MenuItem mapToMenuItem(UpdateMenuItemDTO menuItemDTO);
}
