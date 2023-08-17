package com.example.mariabonitaskincareroutineapi.domain.products;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

// @Table(name = "products")
@Entity
@Data
//@Getter
//@NoArgsConstructor
public class Products {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;
    private String name;
    private String company;
  float price;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Category> categories = new ArrayList<>();

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  private List<SkinType> skinTypes = new ArrayList<>();

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  protected List<Feature> features = new ArrayList<>();




}



// public void addCategory(Category category) {
//    categories.add(category);
//    category.setProducts(this);
//  }