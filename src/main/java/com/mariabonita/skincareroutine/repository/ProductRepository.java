package com.mariabonita.skincareroutine.repository;

import com.mariabonita.skincareroutine.domain.products.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

  //  List<Product> findAllByCategories_idCategory(Long id);

}
