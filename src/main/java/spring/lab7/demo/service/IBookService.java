package spring.lab7.demo.service;

import spring.lab7.demo.entity.Book;

import java.util.List;

public interface IBookService {
    List<Book> getBooksIsAvailability();
    List<Book> getBooksByName(String name);
    List<Book> getBooksByAuthor(String author);
    List<Book> getBooksByDescription(String description);
    List<Book> getAll();
}
