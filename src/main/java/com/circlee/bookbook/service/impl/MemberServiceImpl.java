package com.circlee.bookbook.service.impl;

import com.circlee.bookbook.domain.member.Member;
import com.circlee.bookbook.domain.member.MemberRole;
import com.circlee.bookbook.enums.MemberRoleType;
import com.circlee.bookbook.repository.member.MemberRepository;
import com.circlee.bookbook.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final PasswordEncoder passwordEncoder;

    private final MemberRepository memberRepository;

    @Override
    public Member createMember(Member member) {
        MemberRole role = new MemberRole();
        member.setUpw(passwordEncoder.encode(member.getUpw()));
        role.setMemberRoleType(MemberRoleType.USER);
        member.setRoles(Arrays.asList(role));
        memberRepository.save(member);
        return member;
    }
}
