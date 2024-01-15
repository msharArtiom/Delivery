package by.tms.delivery.dto.request;

import by.tms.delivery.entity.address.Address;
import by.tms.delivery.entity.restaurant.MenuItem;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@Component
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRestaurantDTO {

    @NotBlank
    @NotEmpty
    private String name;

    @NotBlank
    @NotEmpty
    private Set<Address> address;

    @NotBlank
    @NotEmpty
    private List<MenuItem> itemList;
}
