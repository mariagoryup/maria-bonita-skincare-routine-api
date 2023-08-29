/**package com.mariabonita.skincareroutine.service;

import com.mariabonita.skincareroutine.domain.products.StepCategory;
import com.mariabonita.skincareroutine.repository.StepCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StepCategoryService {

    final StepCategoryRepository stepCategoryRepository;

    public List<StepCategory> findAll() {
        return stepCategoryRepository.findAll();
    }

    public StepCategory findById(Long idStepCategory) {
        return stepCategoryRepository.findById(idStepCategory).orElseThrow();
    }
}
*/