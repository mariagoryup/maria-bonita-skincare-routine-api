package com.mariabonita.skincareroutine.domain.products;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mariabonita.skincareroutine.domain.client.MyUser;
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
    @ManyToOne
    @JsonIgnore
    MyUser myUser;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Step> steps = new ArrayList<>();

    public void addStep(Step step) {
        steps.add(step);
        step.setRoutine(this);
    }
}
