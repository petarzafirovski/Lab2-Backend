package mk.ukim.finki.elibrary.service.impl;

import mk.ukim.finki.elibrary.model.Country;
import mk.ukim.finki.elibrary.repository.AuthorRepository;
import mk.ukim.finki.elibrary.repository.CountryRepository;
import mk.ukim.finki.elibrary.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImplementation implements CountryService {
    private final CountryRepository countryRepository;
    private final AuthorRepository authorRepository;

    public CountryServiceImplementation(CountryRepository countryRepository, AuthorRepository authorRepository) {
        this.countryRepository = countryRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Optional<Country> save(String name, String continent) {
        Country country = new Country(name,continent);

        this.countryRepository.save(country);
        return Optional.of(country);
    }

    @Override
    public Optional<Country> findById(Long id) {
        return this.countryRepository.findById(id);
    }
}
