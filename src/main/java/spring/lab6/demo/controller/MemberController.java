package spring.lab6.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.lab6.demo.entity.Member;
import spring.lab6.demo.service.implement.MemberService;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {
    @Autowired
    private MemberService memberService;

    // GET
    @GetMapping("")
    public List<Member> getAllMembers() {
        return memberService.getAll();
    }

    @GetMapping("/hello")
    public String getHello() {
        return "Hello World!";
    }

//    @GetMapping("")
//    public Member getMember(@RequestParam("login") String login) {
//        return memberService.getByLogin(login);
//    }

    @PostMapping("/create")
    public Member createNewMember(@RequestBody Member member) {
        return memberService.createMember(member);
    }
}
