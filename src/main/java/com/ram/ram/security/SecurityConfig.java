package com.ram.ram.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .antMatchers("/api/**", "/api/rest/**").hasRole("API_USER")
                                .antMatchers("/tabla/**").hasRole("API_USER")
                                .antMatchers("/**").authenticated()
                )
                .formLogin(withDefaults())
                .logout(withDefaults());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails usuario1 = User.builder().username("Justin")
                .password(passwordEncoder().encode("123"))
                .roles("USER", "API_USER").build();
        UserDetails usuario2 = User.builder().username("heylin")
                .password(passwordEncoder().encode("123"))
                .roles("USER").build();
        return new InMemoryUserDetailsManager(usuario1, usuario2);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
