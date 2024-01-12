package by.tms.delivery.dto.request;

import lombok.*;


@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequest {

    @NonNull
    private String name;

    @NonNull
    private String surname;

    @NonNull
    private String username;

    @NonNull
    private String email;

    @NonNull
    private String password;
}
