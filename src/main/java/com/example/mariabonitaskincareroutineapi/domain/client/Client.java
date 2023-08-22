package com.example.mariabonitaskincareroutineapi.domain.client;
import com.example.mariabonitaskincareroutineapi.domain.products.Routine;
import com.example.mariabonitaskincareroutineapi.enums.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Table(name = "client" )
@Entity
@Getter
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    @Enumerated(EnumType.STRING)
    private Age age;

    @Enumerated(EnumType.STRING)
    private SkinTypeClient skinTypeClient;

    @Enumerated(EnumType.STRING)
    private HowMuch howMuch;

    @Enumerated(EnumType.STRING)
    private PigmentedSkin pigmentedSkin;

    @Enumerated(EnumType.STRING)
    private SensitiveSkin sensitiveSkin;

    @OneToMany (cascade = CascadeType.ALL, orphanRemoval = true)
    List<Routine> routines = new ArrayList<>();

}
