package mk.ukim.finki.elibrary.config;

import mk.ukim.finki.elibrary.model.Country;
import mk.ukim.finki.elibrary.model.enums.Role;
import mk.ukim.finki.elibrary.service.AuthorService;
import mk.ukim.finki.elibrary.service.CountryService;
import mk.ukim.finki.elibrary.service.UserService;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.List;


@Component
public class DataInitializer {

    private final CountryService countryService;

    private final AuthorService authorService;

    private final UserService userService;

    public DataInitializer(CountryService countryService, AuthorService authorService, UserService userService) {
        this.countryService = countryService;
        this.authorService = authorService;
        this.userService = userService;
    }


    @PostConstruct
    public void initData() {
        this.userService.save("library_admin","librarian","administrator", Role.LIBRARIAN);
        this.userService.save("guest_user","guest","user", Role.USER);

        this.countryService.save("UK","Europe");
        this.countryService.save("USA","North America");

        List<Country> countries = this.countryService.findAll();

        this.authorService.save("J. K.","Rowling",countries.get(0).getId());
        this.authorService.save("Ernest","Hemingway",countries.get(1).getId());

    }
}
