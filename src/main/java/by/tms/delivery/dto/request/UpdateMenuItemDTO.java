package by.tms.delivery.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@Component
@NoArgsConstructor
@AllArgsConstructor
public class UpdateMenuItemDTO {

    @NotBlank
    @NotEmpty
    private String name;

    @NotBlank
    @NotEmpty
    private BigDecimal price;

    @NotBlank
    @NotEmpty
    private byte[] image;

    @NotBlank
    @NotEmpty
    private String description;
}
