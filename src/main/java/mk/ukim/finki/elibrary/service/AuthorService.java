package mk.ukim.finki.elibrary.service;

import mk.ukim.finki.elibrary.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> findAll();
    Optional<Author> save(String name,String surname,Long countryId);
    Optional<Author> findById(Long id);
}
