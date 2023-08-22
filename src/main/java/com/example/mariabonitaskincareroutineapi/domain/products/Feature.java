package com.example.mariabonitaskincareroutineapi.domain.products;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idFeature;
    String name;

    @ManyToOne
    @JsonIgnore
    private Products products;
}
