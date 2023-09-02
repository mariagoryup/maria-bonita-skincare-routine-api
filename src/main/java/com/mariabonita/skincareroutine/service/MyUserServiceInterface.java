package com.mariabonita.skincareroutine.service;

import com.mariabonita.skincareroutine.domain.Role;
import com.mariabonita.skincareroutine.domain.myuser.MyUser;

import java.util.List;

public interface MyUserServiceInterface {

    MyUser saveMyUser(MyUser myUser);


    Role saveRole(Role role);

    void addRoleToUser(String email, String roleName);
    MyUser getUser(String email);


    List<MyUser> getUsers();

    MyUser getUserByEmail(String email);
}

