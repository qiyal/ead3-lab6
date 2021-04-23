package spring.lab6.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import spring.lab6.demo.entity.Book;
import spring.lab6.demo.entity.Collection;
import spring.lab6.demo.service.implement.BookService;
import spring.lab6.demo.service.implement.CollectionService;

import java.util.List;

@RestController
@RequestMapping("/collections")
public class CollectionController {
    @Autowired
    private CollectionService collectionService;
    @Autowired
    private BookService bookService;

    // GET - 1
    @GetMapping("")
    public List<Collection> getAllCollections() {
        return collectionService.getAll();
    }

    // POST - 1
    @PostMapping("/create")
    public Collection saveNewCollection(@RequestBody Collection collection) {
        return collectionService.save(collection);
    }

    // PUT - 1
    @PutMapping("/update")
    public Collection putCollection(@RequestBody Collection collection) {
        return collectionService.save(collection);
    }

    // PATCH - 1
    @PatchMapping("/{id}")
    public Collection addBookInCollection(@PathVariable("id") Long collectionId, @RequestParam("bookId") Long bookId) {
        Book book = bookService.getBookById(bookId);
        Collection collection = collectionService.getById(collectionId);
        collection.getBooks().add(book);
        return collectionService.save(collection);
    }

    // DELETE - 1
    @DeleteMapping("/{id}")
    public void deleteCollection(@PathVariable Long id) {
        collectionService.delete(id);
    }
}
