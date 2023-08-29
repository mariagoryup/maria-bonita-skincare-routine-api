package com.mariabonita.skincareroutine.domain.products;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class SkinType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idSkinType;
    String name;

    @ManyToMany
    @JsonIgnore
    private List<Product> products = new ArrayList<>();
}
