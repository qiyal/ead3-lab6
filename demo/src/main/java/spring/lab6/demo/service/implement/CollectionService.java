package spring.lab6.demo.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.lab6.demo.entity.Collection;
import spring.lab6.demo.repository.CollectionRepository;
import spring.lab6.demo.service.ICollectionService;

@Service
public class CollectionService implements ICollectionService {
    @Autowired
    private CollectionRepository collectionRepository;

    @Override
    public void save(Collection collection) {
        collectionRepository.save(collection);
    }
}
