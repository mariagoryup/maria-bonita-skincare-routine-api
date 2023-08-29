package com.mariabonita.skincareroutine.repository;

import com.mariabonita.skincareroutine.domain.client.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<MyUser, Long> {
}
