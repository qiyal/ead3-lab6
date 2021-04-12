package spring.lab7.demo.service;

import spring.lab7.demo.entity.Member;

public interface IMemberService {
    boolean checkByLoginAndPassword(String login, String password);
    Member getByLogin(String login);
}
