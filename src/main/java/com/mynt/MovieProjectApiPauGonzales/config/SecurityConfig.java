package com.mynt.MovieProjectApiPauGonzales.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeRequests(auth -> {
                    auth.requestMatchers("/").permitAll()  // Allow public access to root endpoint
                            .requestMatchers("/h2-console/**").permitAll()  // Allow access to H2 console
                            .anyRequest().authenticated();  // Require authentication for all other requests
                })
                .oauth2Login(oauth2 -> oauth2
                        .userInfoEndpoint(userInfo -> userInfo
                                .userAuthoritiesMapper(this::mapRolesToAuthorities)  // Map OAuth2 roles to Spring roles
                        )
                )
                .csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"))  // Disable CSRF for H2 console
                .headers(headers -> headers.frameOptions().sameOrigin())  // Allow iframe for H2 console
                .build();
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<? extends GrantedAuthority> grantedAuthorities) {
        return grantedAuthorities;
    }

    // Mapping OAuth2 roles to Spring Security authorities
    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(OAuth2User user) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        String email = user.getAttribute("email");

        // Example logic: check the user's email and map roles
        if (email != null && email.endsWith("@mydomain.com")) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else {
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }

        return authorities;
    }
}
