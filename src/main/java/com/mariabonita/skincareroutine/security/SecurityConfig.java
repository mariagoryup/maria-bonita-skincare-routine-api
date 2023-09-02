package com.mariabonita.skincareroutine.security;

import com.mariabonita.skincareroutine.filters.CustomAuthenticationFilter;
import com.mariabonita.skincareroutine.filters.CustomAuthorizationFilter;
import com.mariabonita.skincareroutine.service.MyUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
public class SecurityConfig {

    private final AuthenticationManagerBuilder authManagerBuilder;


  @Bean
    public PasswordEncoder encoder() { return PasswordEncoderFactories.createDelegatingPasswordEncoder();
   }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }


    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // CustomAuthenticationFilter instance created
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authManagerBuilder.getOrBuild());
        // set the URL that the filter should process
        customAuthenticationFilter.setFilterProcessesUrl("/api/login");
        // disable CSRF protection
    //    http.csrf().disable();
        // set the session creation policy to stateless
      http.sessionManagement().sessionCreationPolicy(STATELESS);
        // set up authorization for different request matchers and user roles
        // modify this to have different configurations
        http.authorizeHttpRequests((requests) -> requests
                .requestMatchers("/api/login").permitAll()
          //      .requestMatchers("/swagger-ui/**").permitAll() //TODO verify how to make it work with security
                .requestMatchers(GET, "/api/v1/users/me").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                .requestMatchers(GET, "/api/v1/users").hasAnyAuthority("ROLE_ADMIN")
                .requestMatchers(POST, "/api/v1/users").hasAnyAuthority("ROLE_ADMIN")
                .requestMatchers(GET, "/api/v1/greet").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                .requestMatchers(GET, "/api/v1/greet/admin").hasAnyAuthority("ROLE_ADMIN")
                .anyRequest().permitAll()); // todo
        // add the custom authentication filter to the http security object
        http.addFilter(customAuthenticationFilter);
        // Add the custom authorization filter before the standard authentication filter.
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

        // Build the security filter chain to be returned.
        return http.build();
    }
}