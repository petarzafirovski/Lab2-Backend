package mk.ukim.finki.elibrary.service.impl;

import mk.ukim.finki.elibrary.model.Author;
import mk.ukim.finki.elibrary.model.Book;
import mk.ukim.finki.elibrary.model.dto.BookDTO;
import mk.ukim.finki.elibrary.model.exceptions.AuthorNotFoundException;
import mk.ukim.finki.elibrary.model.exceptions.BookNotFoundException;
import mk.ukim.finki.elibrary.repository.AuthorRepository;
import mk.ukim.finki.elibrary.repository.BookRepository;
import mk.ukim.finki.elibrary.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImplementation implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImplementation(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> save(BookDTO bookDTO) {
        Author author = this.authorRepository.findById(bookDTO.getAuthorId()).orElseThrow(()-> new AuthorNotFoundException(bookDTO.getAuthorId()));
        Book book = new Book(bookDTO.getName(),bookDTO.getCategory(),author,bookDTO.getAvailableCopies());
        this.bookRepository.save(book);

        return Optional.of(book);
    }

    @Override
    public Optional<Book> update(Long id, BookDTO bookDTO) {
        Book book = this.bookRepository.findById(id).orElseThrow(()->new BookNotFoundException(id));

        book.setName(bookDTO.getName());

        Author author = this.authorRepository.findById(bookDTO.getAuthorId()).orElseThrow(()->new AuthorNotFoundException(id));
        book.setAuthor(author);

        book.setCategory(bookDTO.getCategory());

        book.setAvailableCopies(bookDTO.getAvailableCopies());

        this.bookRepository.save(book);

        return Optional.of(book);

    }

    @Override
    public void markAsTaken(Long id) {
        Book book = this.bookRepository.findById(id).orElseThrow(()->new BookNotFoundException(id));
        Integer copies = book.getAvailableCopies();
        if(copies==0)
            return;
        book.setAvailableCopies(copies-1);
        this.bookRepository.save(book);
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }
}
