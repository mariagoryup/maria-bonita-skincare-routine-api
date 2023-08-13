package com.example.mariabonitaskincareroutineapi.domain.products;

import com.example.mariabonitaskincareroutineapi.enums.AntiAge;
import com.example.mariabonitaskincareroutineapi.enums.PigmentedSkin;
import com.example.mariabonitaskincareroutineapi.enums.SkinType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "3_serum")
@Entity
@Getter
@NoArgsConstructor
public class SerumStepThree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSerum;
    private String name;
    private String company;

    @Enumerated(EnumType.STRING)
    private SkinType skinType;

    float price;

    @Enumerated(EnumType.STRING)
    private PigmentedSkin pigmentedSkin;

    @Enumerated(EnumType.STRING)
    private AntiAge antiAge;

}
