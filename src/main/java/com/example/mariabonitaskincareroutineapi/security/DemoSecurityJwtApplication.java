package com.example.mariabonitaskincareroutineapi.security;

import com.example.mariabonitaskincareroutineapi.domain.user.User;
import com.example.mariabonitaskincareroutineapi.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.management.relation.Role;
import java.util.ArrayList;

@SpringBootApplication
public class DemoSecurityJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSecurityJwtApplication.class, args);
    }


    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));

            userService.saveUser(new User("maria maria", "maria@maria.com", "123456", new ArrayList<>()));
            userService.saveUser(new User("vinnie goryup", "vinnie@vinnie.com", "123589", new ArrayList<>()));
            userService.saveUser(new User("maria julia", "maria@julia", "1234", new ArrayList<>()));
            userService.saveUser(new User("maria flor", "maria@flor", "1234", new ArrayList<>()));

            userService.addRoleToUser("mariamaria", "ROLE_USER");
            userService.addRoleToUser("vinniegoryup", "ROLE_ADMIN");
            userService.addRoleToUser("mariajulia", "ROLE_USER");
            userService.addRoleToUser("mariaflor", "ROLE_ADMIN");
        };
    }

}


