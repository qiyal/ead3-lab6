package spring.lab6.demo.service;

import spring.lab6.demo.entity.Book;

import java.util.List;

public interface IBookService {
    List<Book> getAll();
    Book getBookById(Long id);
    List<Book> getBooksByNameOrAuthorOrDesc(String name, String author, String description);
}
