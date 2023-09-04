package com.mariabonita.skincareroutine.controller;

import com.mariabonita.skincareroutine.domain.Role;
import com.mariabonita.skincareroutine.dto.RoleToMyUserDTO;
import com.mariabonita.skincareroutine.service.MyUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor //*
public class RoleController implements RoleControllerInterface {

//*    @Autowired
    private MyUserService myUserService;


    @PostMapping //*("/api/roles")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveRole(@RequestBody Role role) {
        myUserService.saveRole(role);
    }

        @PostMapping("addtomyuser")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void addRoleToMyUser (@RequestBody RoleToMyUserDTO roleToMyUserDTO){
            myUserService.addRoleToMyUser(roleToMyUserDTO.getEmail(), roleToMyUserDTO.getRoleName());
        }
    }

