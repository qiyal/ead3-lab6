package spring.lab6.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.lab6.demo.entity.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> getBooksBy();
    Book getBookById(Long id);
    List<Book> getBooksByQuantityIsNot(Integer quantity);
    List<Book> getBooksByNameContainsOrAuthorContainsOrDescriptionContains(String name, String author, String description);
}
