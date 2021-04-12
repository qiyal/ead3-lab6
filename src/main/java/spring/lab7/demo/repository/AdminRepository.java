package spring.lab7.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.lab7.demo.entity.Admin;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    boolean existsAdminByUsernameAndPassword(String username, String password);
    List<Admin> getAdminsBy();
}
