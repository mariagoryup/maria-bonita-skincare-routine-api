package com.example.mariabonitaskincareroutineapi.domain.products;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCategory;
    String name;

    @ManyToMany
    @JsonIgnore
    private List<Products> products = new ArrayList<>();

    }
