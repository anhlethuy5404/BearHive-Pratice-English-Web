package com.bearhive.bearhive.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
            .requestMatchers("/admin/**").hasAuthority("ADMIN")
            .requestMatchers("/user/**").hasAuthority("USER")
            .requestMatchers("/", "/signup").permitAll()
            .requestMatchers("/css/**", "/image/**", "/js/**").permitAll()
            .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .permitAll()
            )
            .logout(logout -> logout.permitAll());
        return http.build();
    }
}
