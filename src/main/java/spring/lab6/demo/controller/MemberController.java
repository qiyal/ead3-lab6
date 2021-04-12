package spring.lab6.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.lab6.demo.entity.Member;
import spring.lab6.demo.service.implement.MemberService;

@RestController
@RequestMapping("/members")
public class MemberController {
    @Autowired
    private MemberService memberService;

    // GET
    @GetMapping("")
    public Member getMember(@RequestParam("login") String login) {
        return memberService.getByLogin(login);
    }
}
