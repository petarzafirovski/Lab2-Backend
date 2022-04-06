package mk.ukim.finki.elibrary.service;

import mk.ukim.finki.elibrary.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();
    Optional<Country> save(String name,String continent);
    Optional<Country> findById(Long id);
}
