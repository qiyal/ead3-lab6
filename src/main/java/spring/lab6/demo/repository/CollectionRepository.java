package spring.lab6.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.lab6.demo.entity.Collection;

import java.util.List;

@Repository
public interface CollectionRepository extends JpaRepository<Collection, Long> {
    List<Collection> getCollectionsBy();
    Collection getCollectionById(Long id);
}
