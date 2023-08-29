package com.example.mariabonitaskincareroutineapi.controller;

import com.example.mariabonitaskincareroutineapi.domain.user.Role;
import com.example.mariabonitaskincareroutineapi.service.UserService;
import com.example.mariabonitaskincareroutineapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RoleControllerImplementations extends RoleController {

    private final UserService userService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveRole(@RequestBody Role role) {userService.saveRole();}

    @PostMapping("addtouser")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addRoleToUser addRoleToUser(@RequestBody RoleToUserRecordDTO roleToUserRecordDTO) {
        userService.addRoleToUser (roleToUserRecordDTO.getEmail(), roleToUserRecordDTO.getRoleName());
    }

}
