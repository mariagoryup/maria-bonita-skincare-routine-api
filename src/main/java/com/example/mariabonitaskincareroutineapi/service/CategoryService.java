package com.example.mariabonitaskincareroutineapi.service;

import com.example.mariabonitaskincareroutineapi.repository.CategoryRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
}
