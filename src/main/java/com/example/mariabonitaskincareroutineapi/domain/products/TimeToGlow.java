package com.example.mariabonitaskincareroutineapi.domain.products;

import com.example.mariabonitaskincareroutineapi.enums.SkinType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "7_time_to_glow")
@Entity
@Getter
@NoArgsConstructor
public class TimeToGlow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTwiceAWeek;
    private String name;
    private String company;

    @Enumerated(EnumType.STRING)
    private SkinType skinType;

    float price;

}
