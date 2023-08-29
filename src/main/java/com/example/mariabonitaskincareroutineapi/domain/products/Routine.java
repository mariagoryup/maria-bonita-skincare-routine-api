package com.example.mariabonitaskincareroutineapi.domain.products;

import com.example.mariabonitaskincareroutineapi.domain.user.User;
import com.example.mariabonitaskincareroutineapi.domain.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Routine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idRoutine;
    String name;
    @ManyToOne
    @JsonIgnore
    User user;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Step> steps = new ArrayList<>();

    public void addStep(Step step) {
        steps.add(step);
        step.setRoutine(this);
    }

    public void setUser(User user) {
    }
}
