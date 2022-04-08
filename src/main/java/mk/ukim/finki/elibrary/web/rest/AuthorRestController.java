package mk.ukim.finki.elibrary.web.rest;

import mk.ukim.finki.elibrary.model.Author;
import mk.ukim.finki.elibrary.service.AuthorService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://elibrary-backend-191537.herokuapp.com")
@RequestMapping("/api/authors")
public class AuthorRestController {
    private final AuthorService authorService;

    public AuthorRestController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> getAuthors(){
        return this.authorService.findAll();
    }
}
