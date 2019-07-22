package com.circlee.bookbook;


import com.circlee.bookbook.domain.member.Member;
import com.circlee.bookbook.domain.member.MemberRole;
import com.circlee.bookbook.enums.MemberRoleType;
import com.circlee.bookbook.repository.member.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @Test
    public void insertMember() {
        for(int i=0; i<100; i++) {
            Member member = new Member();
            member.setUid("user" + i);
            member.setUpw("pw" + i);

            MemberRole role = new MemberRole();
            role.setMemberRoleType(MemberRoleType.USER);
            member.setRoles(Arrays.asList(role));

            memberRepository.save(member);
        }
    }

    @Test
    public void findMember() {
        Optional<Member> result = memberRepository.findById(85L);
        result.ifPresent(member -> log.info("member " + member));
    }
}