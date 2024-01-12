package by.tms.delivery.service;

import by.tms.delivery.config.JwtService;
import by.tms.delivery.dto.request.AuthenticationRequest;
import by.tms.delivery.dto.request.RegistrationRequest;
import by.tms.delivery.dto.response.AuthenticationResponse;
import by.tms.delivery.entity.enums.Role;
import by.tms.delivery.entity.user.User;
import by.tms.delivery.entity.user.UserPrincipal;
import by.tms.delivery.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    private String TOKEN;

    public User register(RegistrationRequest request) {
        User userToRegister = User
                .builder()
                .name(request.getName())
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        userRepository.save(userToRegister);

        return userToRegister;
    }

    public AuthenticationResponse login(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        Optional<User> byUsername = userRepository.findByUsername(request.getUsername());
        if (byUsername.isPresent()) {
            User user = byUsername.get();
            UserPrincipal userPrincipal = UserPrincipal
                    .builder()
                    .username(user.getUsername())
                    .password(user.getPassword())
                    .role(user.getRole())
                    .build();

            TOKEN = jwtService.generateToken(userPrincipal);
        }

        return AuthenticationResponse
                .builder()
                .token(TOKEN)
                .build();
    }
}
