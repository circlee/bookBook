package com.circlee.bookbook.service.impl;

import com.circlee.bookbook.model.auth.CustomUserDetail;
import com.circlee.bookbook.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {


    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return Optional.ofNullable(memberRepository.findTopByUid(username))
                .map(CustomUserDetail::new)
                .orElseThrow(()->{return new UsernameNotFoundException(username);});
    }
}
