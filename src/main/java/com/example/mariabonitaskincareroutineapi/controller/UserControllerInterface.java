package com.example.mariabonitaskincareroutineapi.controller;

import com.example.mariabonitaskincareroutineapi.domain.user.User;

import java.util.List;

public interface UserControllerInterface {

    List<User> getUsers();

    User saveUser(User user);
}