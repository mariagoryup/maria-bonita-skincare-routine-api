package com.example.mariabonitaskincareroutineapi.repository;

import com.example.mariabonitaskincareroutineapi.domain.user.Client;
import com.example.mariabonitaskincareroutineapi.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
