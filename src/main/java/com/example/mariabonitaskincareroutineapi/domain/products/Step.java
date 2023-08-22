package com.example.mariabonitaskincareroutineapi.domain.products;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Step {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idStep;

    @ManyToOne
    private StepCategory name;

    @ManyToOne
    private Products products;


    @ManyToOne
    private Routine routine;

}
