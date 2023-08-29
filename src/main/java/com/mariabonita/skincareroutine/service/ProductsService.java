package com.mariabonita.skincareroutine.service;

import com.mariabonita.skincareroutine.domain.products.*;
import com.mariabonita.skincareroutine.repository.ProductsRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductsService {
    private final ProductsRepository productsRepository;

    public List<Product> findAll() {
        return productsRepository.findAll();
    }

    public Product findById(Long idProducts) {
        return productsRepository.findById(idProducts).orElseThrow();
    }

    @Transactional
    public Product save(Product product) {
        return productsRepository.save(product);
    }

    @Transactional
    public Product update(Long idProducts, Product updatedProduct) {
        Product existingProduct = productsRepository.findById(idProducts)
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
    public Product addCategory(Long idCategory, Category category) {
        Product product = productsRepository.findById(idCategory).orElseThrow();
        product.addCategory(category);
        return productsRepository.save(product);
    }

    public List<Product> findAllByCategory(Long id) {
        return productsRepository.findAllByCategories_idCategory(id);
    }


    @Transactional
    public Product addSkinType(Long idSkinType, SkinType skinType) {
        Product product = productsRepository.findById(idSkinType).orElseThrow();
        product.addSkinType(skinType);
        return productsRepository.save(product);
    }

    @Transactional
    public Product addFeature(Long idFeature, Feature feature) {
        Product product = productsRepository.findById(idFeature).orElseThrow();
        product.addFeature(feature);
        return productsRepository.save(product);
    }

 //   @Transactional
   // public Product addStep(Long idStep, Step step) {
     //   Product product = productsRepository.findById(idStep).orElseThrow();
       // product.addStep(step);
        //return productsRepository.save(product);
    //}

}


//  public List<category> findAll(Optional<String> category_Name) {
//    if (category_Name.isPresent()){
//      return categoryRepository.findAllByCategory_Name(category_Name.get());
//}
//return categoryRepository.findAll();
//}
