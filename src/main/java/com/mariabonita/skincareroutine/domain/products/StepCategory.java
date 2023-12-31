/**package com.mariabonita.skincareroutine.domain.products;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class StepCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idStepCategory;
    String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Step> cleanser = new ArrayList<>();


}
*/