package com.example.mariabonitaskincareroutineapi.repository;

import com.example.mariabonitaskincareroutineapi.domain.products.TwiceAWeek;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TwiceAWeekRepository extends JpaRepository<TwiceAWeek, Long> {
}
