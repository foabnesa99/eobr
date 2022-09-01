package com.ftn.server.security;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableAutoConfiguration
@RequiredArgsConstructor
public class SessionSecurityConfig {

    private final CustomUserDetailsService userDetailsService;

    private final CustomAuthFailureHandler customAuthFailureHandler;

    private final PasswordEncoder passwordEncoder;

    @Bean
    protected SecurityFilterChain filterConfig(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
            .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/img/**", "/icon/**", "/",
                "/login", "/web/user/forgot-password", "/web/user/change-password", "/web/user/verify-email", "/error").permitAll();
        http.authorizeRequests((auths) -> auths.anyRequest().authenticated()).httpBasic(Customizer.withDefaults());
        http.sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS).maximumSessions(20));
        http.exceptionHandling().accessDeniedPage("/forbidden");
        http.formLogin().loginPage("/login").defaultSuccessUrl("/", true)
            .failureUrl("/login-error").failureHandler(customAuthFailureHandler).and().logout().logoutUrl("/perform_logout").logoutSuccessUrl("/").deleteCookies("JSESSIONID");
        return http.build();
    }

    @Bean
    protected DaoAuthenticationProvider daoAuthProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }

}
