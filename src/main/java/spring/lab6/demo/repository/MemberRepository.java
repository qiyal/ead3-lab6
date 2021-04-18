package spring.lab6.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.lab6.demo.entity.Member;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsMemberByLoginAndPassword(String login, String password);
    Member getMemberByLogin(String login);
    Member findByLogin(String login);
    List<Member> getMembersBy();
}
