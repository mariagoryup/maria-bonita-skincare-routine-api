package com.mariabonita.skincareroutine.repository;

import com.mariabonita.skincareroutine.domain.products.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByCategories_idCategory(Long id);

}
