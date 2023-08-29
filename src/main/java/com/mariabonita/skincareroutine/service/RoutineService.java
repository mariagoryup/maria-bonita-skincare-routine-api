package com.mariabonita.skincareroutine.service;

import com.mariabonita.skincareroutine.domain.products.Routine;
import com.mariabonita.skincareroutine.domain.products.Step;
import com.mariabonita.skincareroutine.repository.RoutineRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoutineService {

    final RoutineRepository routineRepository;

    public List<Routine> findAll() {
        return routineRepository.findAll();
    }

    public Routine findById(Long idRoutine) {
        return routineRepository.findById(idRoutine).orElseThrow();
    }

    @Transactional
    public Routine save(Routine routine) {
        return routineRepository.save(routine);
    }

    @Transactional
    public Routine update(Long idRoutine, Routine updatedRoutine) {
        Routine existingRoutine = routineRepository.findById(idRoutine)
                .orElseThrow(() -> new EntityNotFoundException("Routine not found"));
        existingRoutine.setName(updatedRoutine.getName());
        existingRoutine.setSteps(updatedRoutine.getSteps());

        return routineRepository.save(existingRoutine);
    }

    @Transactional
    public void delete(Long idRoutine) {
        routineRepository.deleteById(idRoutine);
    }


    @Transactional
    public Routine addStep(Long idStep, Step step) {
        Routine routine = routineRepository.findById(idStep).orElseThrow();
        routine.addStep(step);
        return routineRepository.save(routine);
    }
}
