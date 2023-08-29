package com.example.mariabonitaskincareroutineapi.controller;

import com.example.mariabonitaskincareroutineapi.domain.products.Routine;
import com.example.mariabonitaskincareroutineapi.domain.products.Step;
import com.example.mariabonitaskincareroutineapi.service.RoutineService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("routine")
public class RoutineController {
    protected final RoutineService routineService;

    @GetMapping
    public List<Routine> getAllRoutine() {
        return routineService.findAll();
    }

    @GetMapping("/{idRoutine}")
    public Routine getRoutineById(@PathVariable Long idRoutine) {
        return routineService.findById(idRoutine);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Routine createRoutine(@RequestBody Routine routine) {
        //return routineService.save(routine);
        return null;
    }

    @DeleteMapping("/{idRoutine}")
    @Transactional
    public ResponseEntity<Void> deleteRoutine(@PathVariable Long idRoutine) {
        try {
            routineService.delete(idRoutine);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("{idRoutine}/step")
    public Routine addStep(@PathVariable("idRoutine") Long idStep, @RequestBody Step step) {
        return routineService.addStep(idStep, step);
    }
}

