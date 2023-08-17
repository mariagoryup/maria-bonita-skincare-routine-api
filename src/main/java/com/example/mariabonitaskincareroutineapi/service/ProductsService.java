package com.example.mariabonitaskincareroutineapi.service;

import com.example.mariabonitaskincareroutineapi.repository.ProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductsService {
    private final ProductsRepository productsRepository;

}
