package com.mariabonita.skincareroutine.repository;

import com.mariabonita.skincareroutine.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import javax.management.relation.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {


    Role findByName(String name);
}