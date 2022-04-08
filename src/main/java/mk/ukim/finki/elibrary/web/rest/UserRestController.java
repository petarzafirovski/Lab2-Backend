package mk.ukim.finki.elibrary.web.rest;

import mk.ukim.finki.elibrary.model.User;
import mk.ukim.finki.elibrary.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://elibrary-backend-191537.herokuapp.com")
@RequestMapping("/api/users")
public class UserRestController {
    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> findAllUsers(){
        return this.userService.listAll();
    }
}
