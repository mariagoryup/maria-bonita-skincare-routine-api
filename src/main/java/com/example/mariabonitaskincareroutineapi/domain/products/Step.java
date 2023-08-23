package com.example.mariabonitaskincareroutineapi.domain.products;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Step {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idStep;

    @ManyToOne
    @JsonIgnore
    private StepCategory name;

    @ManyToOne
    @JsonIgnore
    private Products products;


    @ManyToOne
    @JsonIgnore
    private Routine routine;

}
