package be.digitalycity.java.bxl_java24_demospringmvc.dl.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class BookForm {

    private String isbn;
    private String title;

    public BookForm() {}

    public BookForm(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }
}
