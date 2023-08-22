package com.example.mariabonitaskincareroutineapi.domain.products;

import com.example.mariabonitaskincareroutineapi.domain.client.Client;
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
    List<Step> steps = new ArrayList<>();

    @ManyToOne
    private Client client;
}
