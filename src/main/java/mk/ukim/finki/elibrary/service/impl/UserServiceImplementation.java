package mk.ukim.finki.elibrary.service.impl;

import mk.ukim.finki.elibrary.model.User;
import mk.ukim.finki.elibrary.model.enums.Role;
import mk.ukim.finki.elibrary.repository.UserRepository;
import mk.ukim.finki.elibrary.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {
    private final UserRepository userRepository;

    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> save(String username, String name, String surname, Role role) {
        User user = new User(username,name,surname,role);
        this.userRepository.save(user);
        return Optional.of(user);
    }

    @Override
    public List<User> listAll() {
        return this.userRepository.findAll();
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return Optional.of(this.userRepository.findByUsername(username));
    }
}
