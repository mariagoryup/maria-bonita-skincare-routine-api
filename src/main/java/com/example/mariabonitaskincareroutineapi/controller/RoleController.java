package com.example.mariabonitaskincareroutineapi.controller;

import com.example.mariabonitaskincareroutineapi.dtos.RoleToUserDTO;
import com.example.mariabonitaskincareroutineapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.Role;

@RestController
@RequestMapping("/api")
public class RoleController implements RoleControllerInterface {


  @Autowired
  private UserService userService;

  @PostMapping("/roles")
  @ResponseStatus(HttpStatus.CREATED)
  public void saveRole(@RequestBody Role role) {
    userService.saveRole(role);
  }


  @PostMapping("/roles/adduser")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void addRoleToClient(@RequestBody RoleToUserDTO roleToUserDto) {
    userService.addRoleToUser(roleToUserDto.getUsername(), roleToUserDto.getRoleName());
  }
}