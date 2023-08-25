package com.example.mariabonitaskincareroutineapi.domain.products;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Products {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;
    private String name;
    private String company;
    float price;

  @ManyToMany(cascade = CascadeType.ALL) //, orphanRemoval = true
  private List<Category> categories = new ArrayList<>();
  public void addCategory(Category category) {
    categories.add(category);
    category.getProducts().add(this);
  }

 @ManyToMany (cascade = CascadeType.ALL)//, orphanRemoval = true
  private List<SkinType> skinTypes = new ArrayList<>();
  public void addSkinType(SkinType skinType){
    skinTypes.add(skinType);
    skinType.getProducts().add(this);
  }

 @ManyToMany(cascade = CascadeType.ALL) //, orphanRemoval = true
 private List<Feature> features = new ArrayList<>();
  public void addFeature(Feature feature) {
      features.add(feature);
      feature.getProducts().add(this);
  }

 @ManyToMany (cascade = CascadeType.ALL) //, orphanRemoval = true
  private List<Step> steps = new ArrayList<>();
  public void addStep(Step step) {
      steps.add(step);
      step.getProducts().add(this);
  }







}

