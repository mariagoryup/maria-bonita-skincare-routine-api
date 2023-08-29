package com.mariabonita.skincareroutine.service;

import com.mariabonita.skincareroutine.domain.products.SkinType;
import com.mariabonita.skincareroutine.repository.SkinTypeRepository;
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
