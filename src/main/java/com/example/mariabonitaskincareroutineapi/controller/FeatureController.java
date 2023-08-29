package com.example.mariabonitaskincareroutineapi.controller;

import com.example.mariabonitaskincareroutineapi.domain.products.Feature;
import com.example.mariabonitaskincareroutineapi.service.FeatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("feature")
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