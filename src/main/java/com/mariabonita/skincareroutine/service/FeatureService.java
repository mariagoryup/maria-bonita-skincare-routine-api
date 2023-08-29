package com.mariabonita.skincareroutine.service;

import com.mariabonita.skincareroutine.domain.products.Feature;
import com.mariabonita.skincareroutine.repository.FeatureRepository;
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
