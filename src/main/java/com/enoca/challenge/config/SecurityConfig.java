package com.enoca.challenge.config;

import com.enoca.challenge.exception.AuthException;
import com.enoca.challenge.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@Configuration
public class SecurityConfig {

    private final AuthService authService;

    private static final String[] AUTH_WHITELIST = {
            "/v3/api-docs/**",
            "/swagger-ui/**",
            "/docs/swagger-ui/**",
            "/swagger-ui.html"
    };

    private static final String[] PERMIT_ALL_ENDPOINTS = {
            "/api/v1/customers/signup",
            "/api/v1/customers/login/{email}",
            "/api/v1/customers/get/{email}",
            "/api/v1/customers/get",
            "/api/v1/products/create",
            "/api/v1/products/get/{productId}",
            "/api/v1/products/get",
            "/api/v1/products/get/name/{name}",
            "/api/v1/products/get/category/{category}",
            "/api/v1/products/update/{productId}",
            "/api/v1/products/delete/{productId}"
    };

    private static final String[] CUSTOMER_ENDPOINTS = {
            "/api/v1/customers/update/{id}",
            "/api/v1/customers/delete/{id}",
            "/api/v1/carts/get/{customerId}",
            "/api/v1/carts/add/{customerId}",
            "/api/v1/carts/remove/{customerId}"
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(registry ->{
                    registry.requestMatchers(AUTH_WHITELIST).permitAll();
                    registry.requestMatchers(PERMIT_ALL_ENDPOINTS).permitAll();
                    registry.requestMatchers(CUSTOMER_ENDPOINTS).hasAnyRole("CUSTOMER");
                    registry.anyRequest().authenticated();
                })
                .httpBasic(httpBasicConfigurer -> httpBasicConfigurer
                        .authenticationEntryPoint(unauthorizedEntryPoint())
                )
                .exceptionHandling(exceptionHandlingConfigurer ->
                        exceptionHandlingConfigurer.authenticationEntryPoint(unauthorizedEntryPoint())
                )
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return authService;
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(authService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public AuthenticationEntryPoint unauthorizedEntryPoint() {
        return new AuthException();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
