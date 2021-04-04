package spring.lab6.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import spring.lab6.demo.entity.Book;
import spring.lab6.demo.service.implement.BookService;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    public List<Book> getBooksIsAvailability() {
        return bookService.getBooksIsAvailability();
    }

    public List<Book> getBooksByName(String name) {
        return bookService.getBooksByName(name);
    }

    public List<Book> getBooksByAuthor(String author) {
        return bookService.getBooksByAuthor(author);
    }

    public List<Book> getBooksByDescription(String description) {
        return bookService.getBooksByDescription(description);
    }

    public void decBookQuantitySave(Book book) {
        book.setQuantity(book.getQuantity() - 1);
        bookService.updateBook(book);
    }

    public void incBookQuantitySave(Book book) {
        book.setQuantity(book.getQuantity() + 1);
        bookService.updateBook(book);
    }

    public List<Book> getAllBook() {
        return bookService.getAll();
    }
}
