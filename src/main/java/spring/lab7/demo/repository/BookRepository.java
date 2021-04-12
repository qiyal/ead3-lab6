package spring.lab7.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.lab7.demo.entity.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> getBooksByQuantityIsNot(Integer quantity);
    List<Book> getBooksByNameContaining(String name);
    List<Book> getBooksByAuthorContaining(String author);
    List<Book> getBooksByDescriptionContaining(String description);
    List<Book> getAllBy();
    Book getById (Long id);
}
