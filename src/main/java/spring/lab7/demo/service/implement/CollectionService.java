package spring.lab7.demo.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.lab7.demo.entity.Collection;
import spring.lab7.demo.repository.CollectionRepository;
import spring.lab7.demo.service.ICollectionService;

import java.util.List;

@Service
public class CollectionService implements ICollectionService {
    @Autowired
    private CollectionRepository collectionRepository;

    @Override
    public Collection save(Collection collection) {
        return collectionRepository.save(collection);
    }

    @Override
    public List<Collection> getAll() {
        return collectionRepository.findAll();
    }

    @Override
    public Collection getById(Long id) {
        return collectionRepository.getById(id);
    }
}
