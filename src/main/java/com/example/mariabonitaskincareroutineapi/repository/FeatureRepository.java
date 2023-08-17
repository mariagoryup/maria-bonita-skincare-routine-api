package com.example.mariabonitaskincareroutineapi.repository;

import com.example.mariabonitaskincareroutineapi.domain.products.Feature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeatureRepository extends JpaRepository<Feature, Long> {
}
