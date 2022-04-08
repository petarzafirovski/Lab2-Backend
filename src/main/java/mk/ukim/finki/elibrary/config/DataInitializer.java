package mk.ukim.finki.elibrary.config;

import mk.ukim.finki.elibrary.model.Author;
import mk.ukim.finki.elibrary.model.Country;
import mk.ukim.finki.elibrary.model.dto.BookDTO;
import mk.ukim.finki.elibrary.model.enums.Category;
import mk.ukim.finki.elibrary.model.enums.Role;
import mk.ukim.finki.elibrary.service.AuthorService;
import mk.ukim.finki.elibrary.service.BookService;
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

    private  final BookService bookService;

    public DataInitializer(CountryService countryService, AuthorService authorService, UserService userService, BookService bookService) {
        this.countryService = countryService;
        this.authorService = authorService;
        this.userService = userService;
        this.bookService = bookService;
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

        List<Author> authors = this.authorService.findAll();

        BookDTO bookDTO = new BookDTO("Kniga 1", Category.BIOGRAPHY,authors.get(0).getId(),2);
        this.bookService.save(bookDTO);

    }
}
