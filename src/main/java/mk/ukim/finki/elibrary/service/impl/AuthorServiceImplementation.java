package mk.ukim.finki.elibrary.service.impl;

import mk.ukim.finki.elibrary.model.Author;
import mk.ukim.finki.elibrary.model.Country;
import mk.ukim.finki.elibrary.repository.AuthorRepository;
import mk.ukim.finki.elibrary.repository.BookRepository;
import mk.ukim.finki.elibrary.repository.CountryRepository;
import mk.ukim.finki.elibrary.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImplementation implements AuthorService {
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;
    private final BookRepository bookRepository;

    public AuthorServiceImplementation(AuthorRepository authorRepository, CountryRepository countryRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Optional<Author> save(String name, String surname, Long countryId) {
        Country country = this.countryRepository.findById(countryId).orElseThrow(null);

        Author author = new Author(name,surname,country);
        this.authorRepository.save(author);

        return Optional.of(author);
    }

    @Override
    public Optional<Author> findById(Long id) {
        return this.authorRepository.findById(id);
    }
}
