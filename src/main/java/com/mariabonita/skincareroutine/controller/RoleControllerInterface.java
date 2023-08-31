package com.mariabonita.skincareroutine.controller;

import com.mariabonita.skincareroutine.dto.RoleToMyUserDTO;

import javax.management.relation.Role;

public interface RoleControllerInterface {

    void saveRole(Role role);


    void addRoleToMyUser(RoleToMyUserDTO roleToUserDTO);
}