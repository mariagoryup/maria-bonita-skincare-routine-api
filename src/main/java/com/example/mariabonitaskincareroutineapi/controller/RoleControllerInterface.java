package com.example.mariabonitaskincareroutineapi.controller;

import com.example.mariabonitaskincareroutineapi.dtos.RoleToUserDTO;
import com.example.mariabonitaskincareroutineapi.dtos.RoleToUserDTO;

import javax.management.relation.Role;

public interface RoleControllerInterface {

    void saveRole(Role role);


    void addRoleToUser(RoleToUserDTO roleToUserDtoDTO);
}