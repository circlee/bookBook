package com.circlee.bookbook.config;

import com.circlee.bookbook.domain.member.Member;
import com.circlee.bookbook.domain.member.MemberRole;
import com.circlee.bookbook.enums.MemberRoleType;
import com.circlee.bookbook.model.auth.CustomUserDetail;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

@TestConfiguration
public class SpringSecurityWebAuxTestConfig {

    @Bean
    @Primary
    public UserDetailsService userDetailsService() {


        MemberRole userRole = new MemberRole();
        userRole.setMemberRoleType(MemberRoleType.USER);

        Member member = new Member();
        member.setUpw("");
        member.setUid("test@test.com");
        member.setId(1L);
        member.setRegdate(LocalDateTime.now());
        member.setRoles(Arrays.asList(userRole));

        CustomUserDetail customUserDetail = new CustomUserDetail(member);

        return new InMemoryUserDetailsManager(Arrays.asList(
                customUserDetail
        ));
    }

    @Primary
    @Bean("testAuditorAware")
    public AuditorAware<Long> getAuditorAware(){
        return new AuditorAware<Long>() {
            @Override
            public Optional<Long> getCurrentAuditor() {

                return Optional.of(1L);
            }
        };
    }
}
