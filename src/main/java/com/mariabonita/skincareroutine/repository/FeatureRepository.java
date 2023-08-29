package com.mariabonita.skincareroutine.repository;

import com.mariabonita.skincareroutine.domain.products.Feature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeatureRepository extends JpaRepository<Feature, Long> {
}
