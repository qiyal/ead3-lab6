package spring.lab6.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.lab6.demo.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    boolean existsAdminByUsernameAndPassword(String username, String password);
}
