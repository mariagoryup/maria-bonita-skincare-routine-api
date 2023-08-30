package com.mariabonita.skincareroutine.service;

import com.mariabonita.skincareroutine.domain.products.*;
import com.mariabonita.skincareroutine.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }


    public Product findById(Long idProduct) { return productRepository.findById(idProduct).orElseThrow();
    }

    @Transactional
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Transactional
    public Product update(Long idProduct, Product updatedProduct) {
        Product existingProduct = productRepository.findById(idProduct)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));
        existingProduct.setName(updatedProduct.getName());
        existingProduct.setCompany(updatedProduct.getCompany());
        existingProduct.setPrice(updatedProduct.getPrice());

        return productRepository.save(existingProduct);
    }

    @Transactional
    public void delete(Long idProduct) {
        productRepository.deleteById(idProduct);
    }

    @Transactional
    public Product addCategory(Long idCategory, Category category) {
        Product product = productRepository.findById(idCategory).orElseThrow();
        product.addCategory(category);
        return productRepository.save(product);
    }

   // public List<Product> findAllByCategory(Long id) {
     //   return productsRepository.findAllByCategories_idCategory(id);
    //}


    @Transactional
    public Product addSkinType(Long idSkinType, SkinType skinType) {
        Product product = productRepository.findById(idSkinType).orElseThrow();
        product.addSkinType(skinType);
        return productRepository.save(product);
    }

    @Transactional
    public Product addFeature(Long idFeature, Feature feature) {
        Product product = productRepository.findById(idFeature).orElseThrow();
        product.addFeature(feature);
        return productRepository.save(product);
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
