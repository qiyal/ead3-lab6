package spring.lab6.demo.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.lab6.demo.entity.Member;
import spring.lab6.demo.repository.MemberRepository;
import spring.lab6.demo.service.IMemberService;

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
