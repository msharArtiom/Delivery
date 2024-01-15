package by.tms.delivery.dto.request;

import by.tms.delivery.entity.address.Address;
import by.tms.delivery.entity.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Builder
@Component
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserDTO {

    @NotBlank
    @NotEmpty
    private String name;

    @NotBlank
    @NotEmpty
    private String surname;

    @NotBlank
    @NotEmpty
    private String username;

    @NotBlank
    @NotEmpty
    private String password;

    @NotBlank
    @NotEmpty
    private String email;

    @NotBlank
    @NotEmpty
    private Address address;
}
