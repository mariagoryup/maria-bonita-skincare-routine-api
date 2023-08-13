package com.example.mariabonitaskincareroutineapi.domain.client;
import com.example.mariabonitaskincareroutineapi.enums.Age;
import com.example.mariabonitaskincareroutineapi.enums.HowMuch;
import com.example.mariabonitaskincareroutineapi.enums.PigmentedSkin;
import com.example.mariabonitaskincareroutineapi.enums.SkinType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;


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
    private SkinType skinType;

    @Enumerated(EnumType.STRING)
    private HowMuch howMuch;

    @Enumerated(EnumType.STRING)
    private PigmentedSkin pigmentedSkin;



}
