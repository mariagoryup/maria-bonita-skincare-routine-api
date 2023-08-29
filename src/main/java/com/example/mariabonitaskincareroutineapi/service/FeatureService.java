package com.example.mariabonitaskincareroutineapi.service;

import com.example.mariabonitaskincareroutineapi.domain.products.Feature;
import com.example.mariabonitaskincareroutineapi.repository.FeatureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeatureService {

    private final FeatureRepository featureRepository;

    public List<Feature> findAll() {
        return featureRepository.findAll();
    }

    public Feature findById(Long idFeature) {
        return featureRepository.findById(idFeature).orElseThrow();
    }


}
