package com.mariabonita.skincareroutine.domain.products;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idFeature;
    String name;

    @ManyToMany
    @JsonIgnore
    private List<Product> products = new ArrayList<>();
}
