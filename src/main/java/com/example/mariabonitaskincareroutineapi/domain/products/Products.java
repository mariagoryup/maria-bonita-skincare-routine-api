package com.example.mariabonitaskincareroutineapi.domain.products;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "products")
@Entity
@Getter
@NoArgsConstructor
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;
    private String name;
    private String company;



            @ManyToMany
            @JoinTable(name = "category",
            joinColumns = @JoinColumn(name = "idProduct"),
            inverseJoinColumns = @JoinColumn(name = "idCategory")
            )
    List<Category> categories;

    @ManyToMany(mappedBy = "products")
    List<SkinType> skinType;




    float price;


}
