package com.circlee.bookbook.config;

import com.circlee.bookbook.service.impl.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.*;
import org.springframework.security.web.util.matcher.*;

import java.util.LinkedHashMap;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String PUBLIC_URL = "/public/**";

    private static final RequestMatcher PUBLIC_URLS = new OrRequestMatcher(
            new AntPathRequestMatcher(PUBLIC_URL)
    );

    private static final RequestMatcher PROTECTED_URLS = new NegatedRequestMatcher(PUBLIC_URLS);

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    public UserDetailsService userDetailsService() {
        return customUserDetailsService;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {

        web.ignoring().antMatchers("/css/**", "/js/**", "/favicon.ico");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors();
        http.csrf().disable();





        http.authorizeRequests()
                .antMatchers("/","/view","/view/index","/view/signup","/view/notFound").permitAll()
                .antMatchers("/auth/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .sessionManagement();


        // exception
        LinkedHashMap<RequestMatcher, AuthenticationEntryPoint> entryPoints = new LinkedHashMap<>();
        entryPoints.put(new AntPathRequestMatcher("/api/**") , new Http403ForbiddenEntryPoint());
        entryPoints.put(AnyRequestMatcher.INSTANCE , new LoginUrlAuthenticationEntryPoint("/view/index"));

        http.exceptionHandling()
                .authenticationEntryPoint( new DelegatingAuthenticationEntryPoint(entryPoints))
                //.accessDeniedHandler(new AccessDeniedHandlerImpl("/view/index?error=true"))
                ;

        // login & logout
        http.formLogin().successHandler( new SavedRequestAwareAuthenticationSuccessHandler())
                .loginPage("/view/index")
                .failureUrl("/view/index?error=true")
                .loginProcessingUrl("/auth/login")
                .defaultSuccessUrl("/view/search", false)
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
                .logout()
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/view/index?logout=true");





//        http.addFilterAt(new JsonUsernamePasswordAuthFilter(), UsernamePasswordAuthenticationFilter.class);

    }

    @Primary
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    AuthenticationEntryPoint forbiddenEntryPoint() {
        return new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED);
    }


}
