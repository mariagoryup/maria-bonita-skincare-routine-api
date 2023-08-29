package com.example.mariabonitaskincareroutineapi.service;

import com.example.mariabonitaskincareroutineapi.domain.products.SkinType;
import com.example.mariabonitaskincareroutineapi.repository.SkinTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SkinTypeService {
    private final SkinTypeRepository skinTypeRepository;

    public List<SkinType> findAll() {
        return skinTypeRepository.findAll();
    }

    public SkinType findById(Long idSkinType) {
        return skinTypeRepository.findById(idSkinType).orElseThrow();
    }

}
