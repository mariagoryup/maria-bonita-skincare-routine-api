/**package com.mariabonita.skincareroutine.service;

import com.mariabonita.skincareroutine.domain.products.Step;
import com.mariabonita.skincareroutine.repository.StepRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StepService {

    private final StepRepository stepRepository;

    public List<Step> findAll() {
        return stepRepository.findAll();
    }

    public Step findById(Long idStep) {
        return stepRepository.findById(idStep).orElseThrow();
    }
}
*/