package spring.lab6.demo.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import spring.lab6.demo.entity.Member;
import spring.lab6.demo.repository.MemberRepository;
import spring.lab6.demo.service.IMemberService;

import java.util.List;

@Service
public class MemberService implements IMemberService, UserDetailsService {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public boolean checkByLoginAndPassword(String login, String password) {
        return memberRepository.existsMemberByLoginAndPassword(login, password);
    }

    @Override
    public Member getByLogin(String login) {
        return memberRepository.getMemberByLogin(login);
    }

    @Override
    public List<Member> getAll() {
        return memberRepository.getMembersBy();
    }

    @Override
    public Member saveMember(Member member) {
        return memberRepository.saveAndFlush(member);
    }

    @Override
    public Member createMember(Member member) {
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        return memberRepository.saveAndFlush(member);
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Member member = memberRepository.findByLogin(login);

        if (member == null) {
            throw new UsernameNotFoundException("Member by login=" + login + " not found!");
        }
        return member;
    }
}
