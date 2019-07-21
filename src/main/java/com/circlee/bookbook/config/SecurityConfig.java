package com.circlee.bookbook.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.NegatedRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String PUBLIC_URL = "/public/**";

    private static final RequestMatcher PUBLIC_URLS = new OrRequestMatcher(
            new AntPathRequestMatcher(PUBLIC_URL)
    );

    private static final RequestMatcher PROTECTED_URLS = new NegatedRequestMatcher(PUBLIC_URLS);

//    @Autowired
//    private JwtTokenProvider jwtTokenProvider;

    @Override
    public void configure(WebSecurity web) throws Exception {

        web.ignoring().antMatchers("/css/**", "/js/**", "/favicon.ico");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors();
        http.csrf();
        http.formLogin().disable();
        http.logout().disable();

        http.authorizeRequests()
                .antMatchers("/api/**").hasRole("BASIC")
                .antMatchers("/view/search", "/view/*/detail").hasRole("BASIC")
                .antMatchers("/","/view","/view/index","/view/signup","/view/notFound").permitAll()
                .and().formLogin()
                .loginPage("/view/index")
                .loginProcessingUrl("/auth/login")
                .defaultSuccessUrl("/view/search")
                .failureUrl("/view/index")
                .and()
                .logout();


        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        http.authorizeRequests()
//                .antMatchers(PUBLIC_URL).permitAll()
//                .anyRequest()
//                .authenticated();

        //http.addFilterBefore(jwtTokenFilter(jwtTokenProvider),UsernamePasswordAuthenticationFilter.class);
//        http.exceptionHandling().defaultAuthenticationEntryPointFor(forbiddenEntryPoint(), PROTECTED_URLS);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean(BeanIds.AUTHENTICATION_MANAGER)
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }

//    AuthenticationEntryPoint forbiddenEntryPoint() {
//        return new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED);
//    }


//    JwtTokenFilter jwtTokenFilter(JwtTokenProvider jwtTokenProvider) {
//        return new JwtTokenFilter(jwtTokenProvider);
//    }

}
