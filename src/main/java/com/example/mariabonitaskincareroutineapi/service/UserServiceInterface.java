package com.example.mariabonitaskincareroutineapi.service;

import com.example.mariabonitaskincareroutineapi.domain.user.User;

import javax.management.relation.Role;
import java.util.List;

public interface UserServiceInterface {

        User saveUser(User user);


        Role saveRole(Role role);


        void addRoleToUser(String username, String roleName);


        User getUser(String username);


        List<User> getUsers();
    }

