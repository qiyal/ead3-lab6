package spring.lab7.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.lab7.demo.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsMemberByLoginAndPassword(String login, String password);
    Member getMemberByLogin(String login);
}
