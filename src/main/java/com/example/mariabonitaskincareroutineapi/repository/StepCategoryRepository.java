package com.example.mariabonitaskincareroutineapi.repository;

import com.example.mariabonitaskincareroutineapi.domain.products.StepCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StepCategoryRepository extends JpaRepository<StepCategory, Long> {
}
