package com.example.mariabonitaskincareroutineapi.repository;

import com.example.mariabonitaskincareroutineapi.domain.products.SkinType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkinTypeRepository extends JpaRepository<SkinType, Long> {
}
