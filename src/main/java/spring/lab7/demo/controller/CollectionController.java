package spring.lab7.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.lab7.demo.entity.Book;
import spring.lab7.demo.entity.Collection;
import spring.lab7.demo.repository.BookRepository;
import spring.lab7.demo.service.implement.CollectionService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/collections")
public class CollectionController {
    @Autowired
    private CollectionService collectionService;
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("")
    public List<Collection> getAll() {
        return collectionService.getAll();
    }

    @GetMapping("/{id}")
    public Collection getById(@PathVariable Long id) {
        return collectionService.getById(id);
    }

    @PostMapping()
    public Collection saveNewCollection(@RequestBody Collection collection) {
        List<Book> books = new ArrayList<>();

        for (int i = 0; i < collection.getBooks().size(); i++) {
            Long id = collection.getBooks().get(i).getId();

            Book book = bookRepository.getById(id);
            books.add(book);
            System.out.println(book.getName());
        }
        System.out.println(collection.getBooks().size());
        return collectionService.save(collection);
    }
}
