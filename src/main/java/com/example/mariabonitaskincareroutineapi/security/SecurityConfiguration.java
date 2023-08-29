package com.example.mariabonitaskincareroutineapi.security;

import com.example.mariabonitaskincareroutineapi.filters.CustomAuthenticationFilter;
import com.example.mariabonitaskincareroutineapi.filters.CustomAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    @Bean
    public PasswordEncoder encoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();

    }

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManagerBuilder.getOrBuild());
        customAuthenticationFilter.setFilterProcessUrl("/api/login");
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(STATELESS);
        http.authorizeHttpRequests((requests) ->
                requests.requestMatchers("/api/username/**").permitAll()
                        .requestMatchers(GET,"/api/users").hasAnyAuthority("ROLE_ADMIN")
                        .requestMatchers(POST, "/api/users").hasAnyAuthority("ROLE_ADMIN")
                        .requestMatchers(GET, "/api/v1/users").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                        .anyRequest().authenticated());
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();


    }

    }


