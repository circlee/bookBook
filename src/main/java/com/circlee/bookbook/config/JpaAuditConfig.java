package com.circlee.bookbook.config;

import com.circlee.bookbook.model.auth.CustomUserDetail;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Configuration
@EnableJpaAuditing
public class JpaAuditConfig {

    @Bean
    public AuditorAware<Long> getAuditorAware(){
        return new AuditorAware<Long>() {
            @Override
            public Optional<Long> getCurrentAuditor() {

                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

                return Optional.ofNullable(authentication)
                        .filter(Authentication::isAuthenticated)
                        .map(Authentication::getPrincipal)
                        .map(obj -> (CustomUserDetail)obj)
                        .map(CustomUserDetail::getId);
            }
        };
    }
}