package com.example.mariabonitaskincareroutineapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.management.relation.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    static Role findByName(String name);
}