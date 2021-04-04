package spring.lab6.demo.service;

import spring.lab6.demo.entity.Member;

public interface IMemberService {
    boolean checkByLoginAndPassword(String login, String password);
    Member getByLogin(String login);
}
