package be.digitalycity.java.bxl_java24_demospringmvc.pl.controllers;

import be.digitalycity.java.bxl_java24_demospringmvc.dl.model.Book;
import be.digitalycity.java.bxl_java24_demospringmvc.dl.model.BookForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/book")
public class BookController {

    private List<Book> books = new ArrayList<>();

    public BookController() {
        books.add(new Book("1234", "V for Vendetta"));
        books.add(new Book("5678", "Watchmen"));
        books.add(new Book("9123", "Carbon & Silicium"));
    }

    //    @GetMapping("/book/{id}")
//    public String book(
//            @PathVariable
//            int id,
//            Model model
//    ) {
//        if (id >= 0 && id < books.size()) {
//            String sentence = "This is " + books.get(id) + " !";
//            model.addAttribute("sentence", sentence);
//            return "book";
//        }
//        else {
//            return "error404";
//        }
//    }

    @GetMapping()
    public String book(Model model) {
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/{isbn}")
    public String getOne(
            @PathVariable
            String isbn,
            Model model
    ) {
        Book book = null;
        try {
            book = books.stream()
                    .filter(b -> b.isbn().equals(isbn)).findFirst().orElseThrow();
            model.addAttribute("book", book);
            return "book";
        } catch (NoSuchElementException e) {
            return "error404";
        }
    }

    @GetMapping("/add")
    public String addBook(Model model) {
        model.addAttribute("book", new BookForm());
        return "add";
    }

    @PostMapping("/add")
    public String addBook(
            @ModelAttribute
            BookForm book,
            Model model
    ) {
        books.add(new Book(book.getIsbn(), book.getTitle()));
        return "redirect:/book";
    }

    @GetMapping("/filter")
    public String filterBooks(
            @RequestParam(name = "title", required = false, defaultValue = "Default")
            String title,
            Model model
    ) {
        return "";
    }
}
