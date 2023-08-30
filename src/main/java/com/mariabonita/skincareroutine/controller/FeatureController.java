package com.mariabonita.skincareroutine.controller;

import com.mariabonita.skincareroutine.domain.products.Feature;
import com.mariabonita.skincareroutine.service.FeatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("features")
public class FeatureController {

    private final FeatureService featureService;

    @GetMapping
    public List<Feature> getAllFeature() {
        return featureService.findAll();
    }

    @GetMapping("/{idFeature}")
    public Feature getFeatureById(@PathVariable Long idFeature) {
        return featureService.findById(idFeature);
    }
}