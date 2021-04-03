package spring.lab6.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.lab6.demo.entity.Collection;

@Repository
public interface CollectionRepository extends JpaRepository<Collection, Long> {

}
