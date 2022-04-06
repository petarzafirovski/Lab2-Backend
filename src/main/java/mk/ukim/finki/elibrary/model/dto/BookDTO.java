package mk.ukim.finki.elibrary.model.dto;

import lombok.Data;
import mk.ukim.finki.elibrary.model.enums.Category;

@Data
public class BookDTO {
    String name;

    Category category;

    Long authorId;

    Integer availableCopies;

    public BookDTO(String name, Category category, Long authorId, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.authorId = authorId;
        this.availableCopies = availableCopies;
    }

    public BookDTO() {
    }
}
