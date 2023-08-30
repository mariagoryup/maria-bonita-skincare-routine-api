package com.mariabonita.skincareroutine.domain.products;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Table(name = "products")
@Entity
@Getter
@NoArgsConstructor
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;

    private String name;

    private String company;

    float price;

   // @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
   @ManyToMany(cascade = CascadeType.ALL) //, orphanRemoval = true
    private List<Category> categories = new ArrayList<>();
    public void addCategory(Category category) {
        categories.add(category);
      //  category.setProducts(this);
        category.getProducts().add(this);
    }

    @ManyToMany(cascade = CascadeType.ALL)//, orphanRemoval = true
    private List<SkinType> skinTypes = new ArrayList<>();
    public void  addSkinType(SkinType skinType) {
        skinTypes.add(skinType);
        //skinType.setProducts(this);
        skinType.getProducts().add(this);
    }

    @ManyToMany(cascade = CascadeType.ALL) //, orphanRemoval = true
    private List<Feature> features = new ArrayList<>();
    public void addFeature(Feature feature) {
        features.add(feature);
       // feature.setProducts(this);
        feature.getProducts().add(this);
    }

    //@ManyToMany(cascade = CascadeType.ALL) //, orphanRemoval = true
    //private List<Step> steps = new ArrayList<>();

   // public void addCategory(Category category) {
     //   categories.add(category);
       // category.getProducts().add(this);
   // }

  //  public void addSkinType(SkinType skinType) {
    //    skinTypes.add(skinType);
      //  skinType.getProducts().add(this);
    //}

    //public void addFeature(Feature feature) {
      //  features.add(feature);
        //feature.getProducts().add(this);
    //}

    //public void addStep(Step step) {
      //  steps.add(step);
        //step.getProducts().add(this);
    //}
    public Product (float price, String name, String company) {
        this.price = price;
        this.name = name;
        this.company = company;

    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", idProduct=" + idProduct +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}

