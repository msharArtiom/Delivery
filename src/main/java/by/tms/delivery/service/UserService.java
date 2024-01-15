package by.tms.delivery.service;

import by.tms.delivery.entity.user.User;
import by.tms.delivery.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Transactional(readOnly = true)
    public Optional<User> findById(Long id) {
        return Optional.of(userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User not found")));
    }

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User update(User user) {
        return userRepository.save(findById(user.getId()).orElseThrow());
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}

