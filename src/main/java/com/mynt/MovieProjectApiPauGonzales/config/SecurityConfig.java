package com.mynt.MovieProjectApiPauGonzales.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeRequests(auth -> {
                    auth.requestMatchers("/").permitAll();  // Allow public access to root endpoint
                    auth.requestMatchers("/h2-console/**").permitAll();  // Allow access to H2 console
                    auth.anyRequest().authenticated();  // Require authentication for all other requests
                })
                .oauth2Login(oauth2 -> oauth2
                        .userInfoEndpoint(userInfo -> userInfo
                                .userAuthoritiesMapper(this::mapRolesToAuthorities) // Map OAuth2 roles to Spring roles
                        )
                )
                .formLogin(withDefaults())  // Enable form login (optional)
                .csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"))
                .headers(headers -> headers.frameOptions().sameOrigin())
                .build();
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<? extends GrantedAuthority> grantedAuthorities) {
        return grantedAuthorities;
    }

    // Mapping the OAuth2 roles to Spring Security authorities
    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(OAuth2User user) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        // Assuming "roles" are not provided by default; you can map based on email, username, or other claims
        // Here we check if the email matches a condition (replace with your condition logic)
        String email = user.getAttribute("email");

        if (email != null && email.endsWith("@mydomain.com")) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else {
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }

        return authorities;
    }
}
