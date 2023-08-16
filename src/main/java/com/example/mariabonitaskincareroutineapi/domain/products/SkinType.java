package com.example.mariabonitaskincareroutineapi.domain.products;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "skinType")
@Entity
@Getter
@NoArgsConstructor
public class SkinType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idSkinType;
    String name;

    @ManyToMany (mappedBy = "skinType")
    List<Products> products;

}
