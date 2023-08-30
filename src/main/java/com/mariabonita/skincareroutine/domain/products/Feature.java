package com.mariabonita.skincareroutine.domain.products;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idFeature;
    String name;

    @ManyToMany(mappedBy = "features")
    @JsonIgnore
    private List<Product> products = new ArrayList<>();

    public Feature(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Feature{" +
                "idFeature=" + idFeature +
                ", name='" + name + '\'' +
                '}';
    }

}

