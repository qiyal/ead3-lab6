package spring.lab7.demo.service;

import spring.lab7.demo.entity.Collection;

import java.util.List;

public interface ICollectionService {
    Collection save(Collection collection);
    List<Collection> getAll();
    Collection getById(Long id);
}
