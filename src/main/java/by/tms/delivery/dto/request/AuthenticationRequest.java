package by.tms.delivery.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {

    @NonNull
    private String username;
    @NonNull
    private String password;
}
