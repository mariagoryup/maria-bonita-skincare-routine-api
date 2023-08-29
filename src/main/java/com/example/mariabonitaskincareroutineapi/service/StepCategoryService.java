package com.example.mariabonitaskincareroutineapi.service;

import com.example.mariabonitaskincareroutineapi.domain.products.StepCategory;
import com.example.mariabonitaskincareroutineapi.repository.StepCategoryRepository;
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
