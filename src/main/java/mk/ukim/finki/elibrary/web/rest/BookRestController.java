package mk.ukim.finki.elibrary.web.rest;

import mk.ukim.finki.elibrary.model.Book;
import mk.ukim.finki.elibrary.model.dto.BookDTO;
import mk.ukim.finki.elibrary.model.enums.Category;
import mk.ukim.finki.elibrary.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/books")
public class BookRestController {
    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> findAll(){
        return this.bookService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id){
        return this.bookService.findById(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @GetMapping("/book-categories")
    public List<Category> getCategories(){
        return Arrays.asList(Category.values());
    }
    @PostMapping("/add")
    public ResponseEntity<Book> save(@RequestBody BookDTO bookDTO){
        return this.bookService.save(bookDTO)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> save(@PathVariable Long id,@RequestBody BookDTO bookDTO){
        return this.bookService.update(id,bookDTO)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Book> deleteById(@PathVariable Long id) {
        this.bookService.deleteById(id);
        if(this.bookService.findById(id).isEmpty()) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/taken/{id}")
    public ResponseEntity<Book> markAsTaken(@PathVariable Long id){
        this.bookService.markAsTaken(id);
        return ResponseEntity.ok().build();
    }
}
