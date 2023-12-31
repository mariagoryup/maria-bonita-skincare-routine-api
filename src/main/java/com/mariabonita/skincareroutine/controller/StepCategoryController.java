/**package com.mariabonita.skincareroutine.controller;

import com.mariabonita.skincareroutine.domain.products.StepCategory;
import com.mariabonita.skincareroutine.service.StepCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("stepCategory")
public class StepCategoryController {

    private final StepCategoryService stepCategoryService;

    @GetMapping
    public List<StepCategory> getAllStepCategory() {
        return stepCategoryService.findAll();
    }

    @GetMapping("/{idStepCategory}")
    public StepCategory getStepCategoryById(@PathVariable Long idStepCategory) {
        return stepCategoryService.findById(idStepCategory);
    }

}*/