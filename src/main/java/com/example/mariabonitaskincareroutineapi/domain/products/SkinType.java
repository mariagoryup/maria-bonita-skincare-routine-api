package com.example.mariabonitaskincareroutineapi.domain.products;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class SkinType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idSkinType;
    String name;

    @ManyToOne
    private Products products;
}
