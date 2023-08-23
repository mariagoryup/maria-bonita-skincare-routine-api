package com.example.mariabonitaskincareroutineapi.controller;

import com.example.mariabonitaskincareroutineapi.domain.products.*;
import com.example.mariabonitaskincareroutineapi.dtos.ProductsRecordDto;
import com.example.mariabonitaskincareroutineapi.repository.ProductsRepository;
import com.example.mariabonitaskincareroutineapi.service.ProductsService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductsController {

    private final ProductsService productsService;

    @GetMapping
    public List<Products> getAllProducts() {
        return productsService.findAll();
    }

    @GetMapping("/{idProducts}")
    public Products getProductsById(@PathVariable Long idProducts) {
        return productsService.findById(idProducts);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Products createProduct(@RequestBody Products products) {
        return productsService.save(products);
    }
    @PutMapping("/{idProducts}")
    @Transactional
    public ResponseEntity<Products> updateProducts(@PathVariable Long idProducts, @RequestBody Products updatedProduct) {
        try {
            Products updated = productsService.update(idProducts, updatedProduct);
            return ResponseEntity.ok(updated);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{idProducts}")
    @Transactional
    public ResponseEntity<Void> deleteProduct(@PathVariable Long idProducts) {
        try {
            productsService.delete(idProducts);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("{idProducts}/categories")
    public Products addCategory(@PathVariable("idProducts") Long idProducts, @RequestBody Category category) {
        return productsService.addCategory(idProducts, category);
    }
    @GetMapping("categories/{id}")
    public List<Products> findAllByCategory(@PathVariable Long id) {
        return productsService.findAllByCategory(id);
    }


    @PostMapping("{idProducts}/skinTypes")
    public Products addSkinType(@PathVariable("idProducts") Long idSkinType, @RequestBody SkinType skinType) {
        return productsService.addSkinType(idSkinType, skinType);
    }

    @PostMapping("{idProducts}/feature")
    public Products addFeature(@PathVariable("idProducts") Long idFeature, @RequestBody Feature feature) {
        return productsService.addFeature(idFeature, feature);
    }

    @PostMapping("{idProducts}/step")
    public Products addStep(@PathVariable("idProducts") Long idStep, @RequestBody Step step) {
        return productsService.addStep(idStep, step);
    }



}
