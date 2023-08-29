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
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCategory;
    String name;

    @ManyToMany
    @JsonIgnore
    private List<Product> products = new ArrayList<>();

    public Category(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Category{" +
                "idCategory=" + idCategory +
                ", name='" + name + '\'' +
                '}';
    }
}
