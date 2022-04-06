package mk.ukim.finki.elibrary.service;

import mk.ukim.finki.elibrary.model.Book;
import mk.ukim.finki.elibrary.model.dto.BookDTO;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> save(BookDTO bookDTO);

    Optional<Book> update(Long id,BookDTO bookDTO);

    void markAsTaken(Long id);

    void deleteById(Long id);

}
