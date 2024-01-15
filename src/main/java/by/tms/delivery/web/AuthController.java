package by.tms.delivery.web;

import by.tms.delivery.dto.request.AuthenticationRequest;
import by.tms.delivery.dto.request.RegistrationRequest;
import by.tms.delivery.dto.response.AuthenticationResponse;
import by.tms.delivery.entity.user.User;
import by.tms.delivery.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@Validated @RequestBody RegistrationRequest request) {
        return new ResponseEntity<>(authenticationService.register(request), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@Validated @RequestBody AuthenticationRequest request) {
        return new ResponseEntity<>(authenticationService.login(request), HttpStatus.OK);
    }

}
