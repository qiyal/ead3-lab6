package spring.lab7.demo.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.lab7.demo.entity.Member;
import spring.lab7.demo.repository.MemberRepository;
import spring.lab7.demo.service.IMemberService;

@Service
public class MemberService implements IMemberService {
    @Autowired
    private MemberRepository memberRepository;

    @Override
    public boolean checkByLoginAndPassword(String login, String password) {
        return memberRepository.existsMemberByLoginAndPassword(login, password);
    }

    @Override
    public Member getByLogin(String login) {
        return memberRepository.getMemberByLogin(login);
    }
}
