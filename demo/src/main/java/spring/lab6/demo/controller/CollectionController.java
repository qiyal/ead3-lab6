package spring.lab6.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import spring.lab6.demo.entity.Collection;
import spring.lab6.demo.service.implement.CollectionService;

@Controller
public class CollectionController {
    @Autowired
    private CollectionService collectionService;

    public void saveNewCollection(Collection collection) {
        collectionService.save(collection);
    }
}
