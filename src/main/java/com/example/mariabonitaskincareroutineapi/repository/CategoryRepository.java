package com.example.mariabonitaskincareroutineapi.repository;

import com.example.mariabonitaskincareroutineapi.domain.products.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
