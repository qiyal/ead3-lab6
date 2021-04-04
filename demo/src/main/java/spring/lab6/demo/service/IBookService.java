package spring.lab6.demo.service;

import spring.lab6.demo.entity.Book;

import java.util.List;

public interface IBookService {
    List<Book> getBooksIsAvailability();
    List<Book> getBooksByName(String name);
    List<Book> getBooksByAuthor(String author);
    List<Book> getBooksByDescription(String description);
    List<Book> getAll();
}
