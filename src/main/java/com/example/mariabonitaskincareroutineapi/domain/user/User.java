package com.example.mariabonitaskincareroutineapi.domain.user;

import com.example.mariabonitaskincareroutineapi.domain.products.Routine;
import com.example.mariabonitaskincareroutineapi.enums.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static jakarta.persistence.FetchType.EAGER;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;

    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;
    @NotBlank
    String password;
    String username;

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

    @ManyToMany(cascade = CascadeType.ALL) //, orphanRemoval = true
    private List<Routine> routines = new ArrayList<>();

    @ManyToMany(fetch = EAGER)
    private Collection<Role> roles = new ArrayList<>();

    public User(String name, String email, String password, Collection<Role> roles) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }


    public void addRoutine(Routine routine) {
        routines.add(routine);
        routine.setUser(this);
    }

    public User(long id, String name, String email, String username, String password, Age age, SkinTypeClient skinTypeClient, HowMuch howMuch,
                PigmentedSkin pigmentedSkin, SensitiveSkin sensitiveSkin) {

        this.name = name;
        this.email = email;
        this.password = password;
        this.username = username;
        this.age = age;
        this.skinTypeClient = skinTypeClient;
        this.howMuch = howMuch;
        this.pigmentedSkin = pigmentedSkin;
        this.sensitiveSkin = sensitiveSkin;

    }

}