package com.example.mariabonitaskincareroutineapi.domain.products;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCategory;
    String name;

    @ManyToOne
    @JsonIgnore
    private Products products;

    }
