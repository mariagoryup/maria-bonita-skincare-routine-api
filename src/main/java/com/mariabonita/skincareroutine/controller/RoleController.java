package com.mariabonita.skincareroutine.controller;

import com.mariabonita.skincareroutine.dto.RoleToMyUserDTO;
import com.mariabonita.skincareroutine.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.Role;

@RestController
@RequestMapping("/api")
public class RoleController implements RoleControllerInterface {

    @Autowired
    private MyUserService myUserService;


    @PostMapping("/api/roles")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveRole(@RequestBody Role role) {
        myUserService.saveRole(role);
    }

        @PostMapping("/roles/addtomyuser")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void addRoleToMyUser (@RequestBody RoleToMyUserDTO roleToMyUserDTO){
            MyUserService.addRoleToMyUser(roleToMyUserDTO.getEmail(), roleToMyUserDTO.getRoleName());
        }
    }

