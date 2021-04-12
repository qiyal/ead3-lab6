package spring.lab6.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.lab6.demo.entity.Admin;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    List<Admin> getAdminsBy();
    boolean existsAdminByUsernameAndPassword(String username, String password);
}
