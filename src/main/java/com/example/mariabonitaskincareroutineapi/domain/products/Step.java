package com.example.mariabonitaskincareroutineapi.domain.products;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Step {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idStep;

    @ManyToOne
    @JsonIgnore
    private StepCategory name;

    @ManyToMany
    @JsonIgnore
    private List<Products> products = new ArrayList<>();


    @ManyToOne
    @JsonIgnore
    private Routine routine;

}
