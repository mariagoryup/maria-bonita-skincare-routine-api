package com.mariabonita.skincareroutine.controller;

import com.mariabonita.skincareroutine.domain.products.Category;
import com.mariabonita.skincareroutine.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategory() {
        return categoryService.findAll();
    }

    @GetMapping("/{idCategory}")
    public Category getCategoryById(@PathVariable Long idCategory) {
        return categoryService.findById(idCategory);
    }

  //  @GetMapping("name")
    //public List<Category> getAllCategory(@RequestParam Optional<String> name) {
      //  return categoryService.findAll(name);
    //}


}
