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
public class SkinType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idSkinType;

    String name;

    @ManyToMany
   // @JsonIgnore
    private List<Product> products = new ArrayList<>();

    public SkinType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SkinType{" +
                "idSkinType=" + idSkinType +
                ", name='" + name + '\'' +
                '}';
    }
}
