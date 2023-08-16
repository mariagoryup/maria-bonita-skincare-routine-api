package com.example.mariabonitaskincareroutineapi.controller;

import com.example.mariabonitaskincareroutineapi.domain.client.Client;
import com.example.mariabonitaskincareroutineapi.domain.products.Products;
import com.example.mariabonitaskincareroutineapi.dtos.ClientRecordDto;
import com.example.mariabonitaskincareroutineapi.dtos.ProductsRecordDto;
import com.example.mariabonitaskincareroutineapi.repository.ClientRepository;
import com.example.mariabonitaskincareroutineapi.repository.ProductsRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @Autowired
    ProductsRepository clientRepository;





}