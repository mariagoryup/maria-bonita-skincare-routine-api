/**package com.mariabonita.skincareroutine.controller;

import com.mariabonita.skincareroutine.domain.products.Step;
import com.mariabonita.skincareroutine.service.StepService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("step")
public class StepController {

    private final StepService stepService;

    @GetMapping
    public List<Step> getAllStep() {
        return stepService.findAll();
    }

    @GetMapping("/{idStep}")
    public Step getStepById(@PathVariable Long idStep) {
        return stepService.findById(idStep);
    }

}
*/