package by.tms.delivery.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

    private String token;
}
