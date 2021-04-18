package spring.lab6.demo.service;

import spring.lab6.demo.entity.Member;

import java.util.List;

public interface IMemberService {
    boolean checkByLoginAndPassword(String login, String password);
    Member getByLogin(String login);
    List<Member> getAll();
    Member saveMember(Member member);
    Member createMember(Member member);
}
