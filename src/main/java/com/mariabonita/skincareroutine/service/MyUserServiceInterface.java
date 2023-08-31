package com.mariabonita.skincareroutine.service;

import com.mariabonita.skincareroutine.domain.Role;
import com.mariabonita.skincareroutine.domain.myuser.MyUser;

import java.util.List;

public interface MyUserServiceInterface {

    MyUser saveMyUser(MyUser myUser);

     //@param role the Role entity to be saved.
     //@return the saved Role entity.

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);
    MyUser getUser(String email);


    List<MyUser> getUsers();

    MyUser getUserByEmail(String email);
}
}
