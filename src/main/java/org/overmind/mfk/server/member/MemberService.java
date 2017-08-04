package org.overmind.mfk.server.member;

import org.overmind.mfk.server.member.Member;
import org.overmind.mfk.server.member.MemberNotFoundException;
import org.overmind.mfk.server.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 26.05.2017 18:33
 */
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public Member findOne(Long id) throws MemberNotFoundException {
        return memberRepository.findOne(id)
            .orElseThrow(
                () -> new MemberNotFoundException(MessageFormat.format("Member with id ''{0}'' not found", id))
            );
    }

    public Member save(Member member) {
        return memberRepository.save(member);
    }

}
