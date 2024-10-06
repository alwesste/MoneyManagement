package com.leopold.moneyManagemet.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Désactive toute la sécurité
        http
                .csrf().disable() // Désactiver CSRF
                .authorizeRequests()
                .anyRequest().permitAll(); // Autoriser toutes les requêtes
        return http.build();
    }
}
