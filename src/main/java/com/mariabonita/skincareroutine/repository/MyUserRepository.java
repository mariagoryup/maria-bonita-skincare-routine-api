package com.mariabonita.skincareroutine.repository;

import com.mariabonita.skincareroutine.domain.myuser.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserRepository extends JpaRepository<MyUser, Long> {

    MyUser findByEmail(String email);
}
