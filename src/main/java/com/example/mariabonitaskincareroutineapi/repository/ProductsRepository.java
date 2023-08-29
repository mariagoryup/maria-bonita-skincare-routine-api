package com.example.mariabonitaskincareroutineapi.repository;

import com.example.mariabonitaskincareroutineapi.domain.products.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Product, Long> {

    // List<Products> findAllByCategories_idCategory(Long id);
    //@Query(nativeQuery = true, value ="select products.* from products\n" +
    //      "inner join products_features on products.id_product = products_features.products_id_product\n" +
    //    "where features_id_feature in :ids ")
    // List<Products> findAllByFeatures(@Param("ids")List<Long> ids);

    // List<Product> findAllByCategory(Category category);

    // List<Product> findAllBySkinType(SkinType skinTypeCl);


    List<Product> findAllBySkinTypesAndCategoriesAndFeaturesAndSteps(SkinType skinType,
                                                                     Category category,
                                                                     Feature feature,
                                                                     Step step);
}
