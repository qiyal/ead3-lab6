package spring.lab6.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import spring.lab6.demo.entity.Member;
import spring.lab6.demo.service.implement.MemberService;

@Controller
public class MemberController {
    @Autowired
    private MemberService memberService;

    public boolean check(String login, String password) {
        return memberService.checkByLoginAndPassword(login, password);
    }

    public Member getMember(String login) {
        return memberService.getByLogin(login);
    }
}
