package spring.lab6.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.lab6.demo.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
