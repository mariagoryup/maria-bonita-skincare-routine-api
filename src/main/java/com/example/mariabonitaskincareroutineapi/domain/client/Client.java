package com.example.mariabonitaskincareroutineapi.domain.client;
import com.example.mariabonitaskincareroutineapi.domain.products.Category;
import com.example.mariabonitaskincareroutineapi.domain.products.Routine;
import com.example.mariabonitaskincareroutineapi.enums.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    @Email
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

    @ManyToMany(cascade = CascadeType.ALL) //, orphanRemoval = true
   private List<Routine> routines = new ArrayList<>();
    public void addRoutine(Routine routine) {
        routines.add(routine);
        routine.setClient(this);
    }

}
