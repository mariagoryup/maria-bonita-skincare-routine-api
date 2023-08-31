package com.mariabonita.skincareroutine.dev;

import com.mariabonita.skincareroutine.domain.Role;
import com.mariabonita.skincareroutine.service.MyUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

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
    CommandLineRunner run(MyUserService MyUserService) {
        return args -> {
            MyUserService.saveRole(new Role(null, "ROLE_USER"));
            MyUserService.saveRole(new Role(null, "ROLE_ADMIN"));

            MyUserService.saveMyUser(new User("jhon@john.com", "123456", new ArrayList<>()));
            MyUserService.saveMyUser(new User(null, "James Smith", "james@james.com", "1234", new ArrayList<>()));
            MyUserService.saveMyUser(new User(null, "Jane Carry", "jane@jane.com", "1234", new ArrayList<>()));
            MyUserService.saveMyUser(new User(null, "Chris Anderson", "chris@chris.com", "1234", new ArrayList<>()));

            MyUserService.addRoleToUser("john", "ROLE_USER");
            MyUserService.addRoleToUser("james", "ROLE_ADMIN");
            MyUserService.addRoleToUser("jane", "ROLE_USER");
            MyUserService.addRoleToUser("chris", "ROLE_ADMIN");
            MyUserService.addRoleToUser("chris", "ROLE_USER");
        };
    }

}