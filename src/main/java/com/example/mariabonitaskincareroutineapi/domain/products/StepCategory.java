package com.example.mariabonitaskincareroutineapi.domain.products;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class StepCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idStepCategory;
    String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Step> steps = new ArrayList<>();

  /*  public List<Step> getCleanserSteps() {
        return steps;
    }
    public List<Step> getTonic() {
        return steps;
    }

    public List<Step> getSerum() {
        return steps;
    }

    public List<Step> getMoisturizer() {
        return steps;
    }
    public List<Step> getSunscreen() {
        return steps;
    }

    public List<Step> getTimeToGlow() {
        return steps;
    }

    public List<Step> getTwiceAWeek() {
        return steps;
    }*/

    @Override
    public String toString() {
        return "StepCategory{" +
                "idStepCategory=" + idStepCategory +
                ", name='" + name + '\'' +
                '}';
    }
}
