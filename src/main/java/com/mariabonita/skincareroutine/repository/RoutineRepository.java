package com.mariabonita.skincareroutine.repository;

import com.mariabonita.skincareroutine.domain.products.Routine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoutineRepository extends JpaRepository<Routine, Long> {
}
