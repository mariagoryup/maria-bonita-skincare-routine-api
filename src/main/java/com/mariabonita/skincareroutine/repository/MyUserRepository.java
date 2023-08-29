package com.mariabonita.skincareroutine.repository;

import com.mariabonita.skincareroutine.domain.myuser.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyUserRepository extends JpaRepository<MyUser, Long> {
}
