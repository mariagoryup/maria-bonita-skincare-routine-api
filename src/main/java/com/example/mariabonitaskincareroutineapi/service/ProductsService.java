package com.example.mariabonitaskincareroutineapi.service;

import com.example.mariabonitaskincareroutineapi.domain.products.Category;
import com.example.mariabonitaskincareroutineapi.domain.products.Products;
import com.example.mariabonitaskincareroutineapi.domain.products.SkinType;
import com.example.mariabonitaskincareroutineapi.repository.ProductsRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductsService {
    private final ProductsRepository productsRepository;

    public List<Products> findAll() {
        return productsRepository.findAll();
    }

    public Products findById(Long idProducts) {
        return productsRepository.findById(idProducts).orElseThrow();
    }

    @Transactional
    public Products save(Products products) {
        return productsRepository.save(products);
    }

    @Transactional
    public Products update(Long idProducts, Products updatedProduct) {
        Products existingProduct = productsRepository.findById(idProducts)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));
        existingProduct.setName(updatedProduct.getName());
        existingProduct.setCompany(updatedProduct.getCompany());
        existingProduct.setPrice(updatedProduct.getPrice());

        return productsRepository.save(existingProduct);
    }

    @Transactional
    public void delete(Long idProducts) {
        productsRepository.deleteById(idProducts);
    }

    @Transactional
    public Products addCategory(Long idCategory, Category category) {
        Products products = productsRepository.findById(idCategory).orElseThrow();
        products.addCategory(category);
        return productsRepository.save(products);
    }

    public List<Products> findAllByCategory(Long id) {
        return productsRepository.findAllByCategories_idCategory(id);
    }


    @Transactional
    public Products addSkinType(Long idSkinType, SkinType skinType) {
        Products products = productsRepository.findById(idSkinType).orElseThrow();
        products.addSkinType(skinType);
        return productsRepository.save(products);
    }


}





//  public List<category> findAll(Optional<String> category_Name) {
//    if (category_Name.isPresent()){
//      return categoryRepository.findAllByCategory_Name(category_Name.get());
//}
//return categoryRepository.findAll();
//}
