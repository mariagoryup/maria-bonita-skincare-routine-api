package com.example.mariabonitaskincareroutineapi.controller;

import com.example.mariabonitaskincareroutineapi.domain.products.Category;
import com.example.mariabonitaskincareroutineapi.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("category")
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

    @GetMapping("name")
    public List<Category> getAllCategory(@RequestParam Optional<String> name) {
        return categoryService.findAll(name);
    }


}
