package com.example.mariabonitaskincareroutineapi.controller;

import com.example.mariabonitaskincareroutineapi.domain.products.*;
import com.example.mariabonitaskincareroutineapi.service.ProductsService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductsController {

    private final ProductsService productsService;

    @GetMapping
    public List<Product> getAllProducts() {
        var p = productsService.findAll();
        return p;
    }

    @GetMapping("/{idProducts}")
    public Product getProductsById(@PathVariable Long idProducts) {
        return productsService.findById(idProducts);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody Product product) {
        return productsService.save(product);
    }

    @PutMapping("/{idProducts}")
    public ResponseEntity<Product> updateProducts(@PathVariable Long idProducts, @RequestBody Product updatedProduct) {
        try {
            Product updated = productsService.update(idProducts, updatedProduct);
            return ResponseEntity.ok(updated);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{idProducts}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long idProducts) {
        try {
            productsService.delete(idProducts);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("{idProducts}/categories")
    public Product addCategory(@PathVariable("idProducts") Long idProducts, @RequestBody Category category) {
        return productsService.addCategory(idProducts, category);
    }

    @GetMapping("categories/{id}")
    public List<Product> findAllByCategory(@PathVariable Long id) {
        // return productsService.findAllByCategory(id);
        return null;
    }


    @PostMapping("{idProducts}/skinTypes")
    public Product addSkinType(@PathVariable("idProducts") Long idSkinType, @RequestBody SkinType skinType) {
        return productsService.addSkinType(idSkinType, skinType);
    }

    @PostMapping("{idProducts}/feature")
    public Product addFeature(@PathVariable("idProducts") Long idFeature, @RequestBody Feature feature) {
        return productsService.addFeature(idFeature, feature);
    }

    @PostMapping("{idProducts}/step")
    public Product addStep(@PathVariable("idProducts") Long idStep, @RequestBody Step step) {
        return productsService.addStep(idStep, step);
    }


}
