package com.example.mariabonitaskincareroutineapi.domain.products;

import com.example.mariabonitaskincareroutineapi.domain.client.Client;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Routine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idRoutine;
    String name;

    @OneToMany (cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Step> steps = new ArrayList<>();
    public void addStep(Step step) {
        steps.add(step);
        step.setRoutine(this);
    }


    @ManyToOne
    @JsonIgnore
    private Client client;
}
