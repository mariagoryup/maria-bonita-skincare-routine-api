package com.mariabonita.skincareroutine.controller;


import com.mariabonita.skincareroutine.domain.products.*;
import com.mariabonita.skincareroutine.repository.ProductRepository;
import com.mariabonita.skincareroutine.service.ProductService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductController {


    ProductRepository productRepository;
    private final ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/{idProduct}")
    public Product getProductById(@PathVariable Long idProduct) {
        return productService.findById(idProduct);
    }

    @Valid
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @Valid
    @PutMapping("/{idProduct}")
    @Transactional
    public ResponseEntity<Product> updateProduct(@PathVariable Long idProduct, @RequestBody Product updatedProduct) {
        try {
            Product updated = productService.update(idProduct, updatedProduct);
            return ResponseEntity.ok(updated);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{idProduct}")
    @Transactional
    public ResponseEntity<Void> deleteProduct(@PathVariable Long idProduct) {
        try {
            productService.delete(idProduct);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Valid
    @PostMapping("{idProduct}/categories")
    public Product addCategory(@PathVariable("idProduct") Long idProduct, @RequestBody Category category) {
        return productService.addCategory(idProduct, category);
    }

   // @GetMapping("categories/{id}")
    //public List<Product> findAllByCategory(@PathVariable Long id) {
      //  return productsService.findAllByCategory(id);
    //}

    @Valid
    @PostMapping("{idProduct}/skinTypes")
    public Product addSkinType(@PathVariable("idProduct") Long idSkinType, @RequestBody SkinType skinType) {
        return productService.addSkinType(idSkinType, skinType);
    }

    @Valid
    @PostMapping("{idProduct}/features")
    public Product addFeature(@PathVariable("idProduct") Long idFeature, @RequestBody Feature feature) {
        return productService.addFeature(idFeature, feature);
    }

 //   @PostMapping("{idProducts}/step")
   // public Product addStep(@PathVariable("idProducts") Long idStep, @RequestBody Step step) {
     //   return productsService.addStep(idStep, step);
    //}


}
