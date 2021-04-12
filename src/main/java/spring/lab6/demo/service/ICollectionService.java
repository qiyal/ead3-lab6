package spring.lab6.demo.service;

import spring.lab6.demo.entity.Collection;

import java.util.List;

public interface ICollectionService {
    List<Collection> getAll();
    Collection getById(Long id);
    Collection save(Collection collection);
    void delete(Long id);
}
