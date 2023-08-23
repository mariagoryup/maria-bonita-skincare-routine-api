package com.example.mariabonitaskincareroutineapi.domain.products;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class StepCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idStepCategory;
    String name;

    @OneToMany (cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Step> steps = new ArrayList<>();










}
