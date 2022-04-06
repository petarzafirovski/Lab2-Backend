package mk.ukim.finki.elibrary.service;

import mk.ukim.finki.elibrary.model.User;
import mk.ukim.finki.elibrary.model.enums.Role;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> save(String username, String name, String surname, Role role);
    List<User> listAll();
    Optional<User> findUserByUsername(String username);
}
