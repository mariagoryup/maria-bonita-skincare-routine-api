package com.example.mariabonitaskincareroutineapi.development;

import com.example.mariabonitaskincareroutineapi.domain.user.Client;
import com.example.mariabonitaskincareroutineapi.domain.user.User;
import com.example.mariabonitaskincareroutineapi.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.management.relation.Role;

import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class DataLoaderUser implements ApplicationListener<ApplicationReadyEvent> {

    private final ClientService userService;
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        userService.saveRole(new Role(null, "ROLE_USER"));
        userService.saveRole(new Role(null, "ROLE_ADMIN"));
        userService.saveRole(new Role("ROLE_USER"));
        userService.saveRole(new Role("ROLE_ADMIN"));

        userService.saveUser(new User("maria maria", "maria@maria.com", "1234", new ArrayList<>()));
        userService.saveUser(new User("maria joana", "maria@joana.com", "1234", new ArrayList<>()));
        userService.saveUser(new User("maria alice", "alice@admin.com", "1234", new ArrayList<>()));

        userService.addRoleToUser("user", "ROLE_USER");
        userService.addRoleToUser("user2", "ROLE_USER");
        userService.addRoleToUser("admin", "ROLE_ADMIN");
    }
}