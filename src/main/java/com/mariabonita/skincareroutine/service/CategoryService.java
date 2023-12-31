package com.mariabonita.skincareroutine.service;

import com.mariabonita.skincareroutine.domain.products.Category;
import com.mariabonita.skincareroutine.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long idCategory) {
        return categoryRepository.findById(idCategory).orElseThrow();
    }

  //  public List<Category> findAll(Optional<String> name) {
    //    if (name.isPresent()) {
      //      return categoryRepository.findAllByName(name.get());
        //}
        //return categoryRepository.findAll();
    //}

}
