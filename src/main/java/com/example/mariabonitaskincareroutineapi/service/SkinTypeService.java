package com.example.mariabonitaskincareroutineapi.service;

import com.example.mariabonitaskincareroutineapi.repository.SkinTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SkinTypeService {
    private final SkinTypeRepository skinTypeRepository;
}
