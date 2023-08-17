package com.example.mariabonitaskincareroutineapi.service;

import com.example.mariabonitaskincareroutineapi.repository.FeatureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FeatureService {
    private final FeatureRepository featureRepository;
}
