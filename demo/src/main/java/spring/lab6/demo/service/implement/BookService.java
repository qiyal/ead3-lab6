package spring.lab6.demo.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.lab6.demo.entity.Book;
import spring.lab6.demo.repository.BookRepository;
import spring.lab6.demo.service.IBookService;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getBooksIsAvailability() {
        return bookRepository.getBooksByQuantityIsNot(0);
    }

    @Override
    public List<Book> getBooksByName(String name) {
        return bookRepository.getBooksByNameContaining(name);
    }

    @Override
    public List<Book> getBooksByAuthor(String author) {
        return bookRepository.getBooksByAuthorContaining(author);
    }

    @Override
    public List<Book> getBooksByDescription(String description) {
        return bookRepository.getBooksByDescriptionContaining(description);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.getAllBy();
    }

    public void updateBook(Book book) {
        bookRepository.save(book);
    }
}
