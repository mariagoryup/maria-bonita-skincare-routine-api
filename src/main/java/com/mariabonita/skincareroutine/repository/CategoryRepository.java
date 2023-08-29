package com.mariabonita.skincareroutine.repository;

import com.mariabonita.skincareroutine.domain.products.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findAllByName(String name);
}
