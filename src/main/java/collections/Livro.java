package collections;

import lombok.Data;

@Data
public class Livro {
    private String isbn;

    public Livro(String isbn) {
        this.isbn = isbn;
    }
}
