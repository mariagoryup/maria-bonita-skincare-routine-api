package com.example.mariabonitaskincareroutineapi.domain.products;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Step {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idStep;

    @ManyToOne
    @JsonIgnore
    private StepCategory name;

    @ManyToMany
    @JsonIgnore
    private List<Product> products = new ArrayList<>();


    @ManyToOne
    @JsonIgnore
    private Routine routine;

    @Override
    public String toString() {
        return "Step{" +
                "idStep=" + idStep +
                ", name=" + name +
                '}';
    }
}
