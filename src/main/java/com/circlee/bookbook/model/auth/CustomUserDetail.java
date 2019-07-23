package com.circlee.bookbook.model.auth;

import com.circlee.bookbook.domain.member.Member;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;


@Data
public class CustomUserDetail implements UserDetails {

    private static final String ROLE_PREFIX = "ROLE_";

    private Long id;
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    private CustomUserDetail(){}

    public CustomUserDetail(Member member) {
        this.id = member.getId();
        this.username = member.getUid();
        this.password = member.getUpw();

        this.authorities = member.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(ROLE_PREFIX + role.getMemberRoleType()))
                .collect(Collectors.toList());

    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
