package com.example.mariabonitaskincareroutineapi.controller;

import com.example.mariabonitaskincareroutineapi.domain.products.Products;
import com.example.mariabonitaskincareroutineapi.domain.products.Routine;
import com.example.mariabonitaskincareroutineapi.domain.products.Step;
import com.example.mariabonitaskincareroutineapi.repository.RoutineRepository;
import com.example.mariabonitaskincareroutineapi.service.RoutineService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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



    @PostMapping("{idRoutine}/step")
    public Routine addStep(@PathVariable("idRoutine") Long idStep, @RequestBody Step step) {
        return routineService.addStep(idStep, step);
    }
}
