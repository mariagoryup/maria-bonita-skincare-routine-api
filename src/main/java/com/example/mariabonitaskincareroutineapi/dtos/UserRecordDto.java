package com.example.mariabonitaskincareroutineapi.dtos;

import com.example.mariabonitaskincareroutineapi.enums.Age;
import com.example.mariabonitaskincareroutineapi.enums.HowMuch;
import com.example.mariabonitaskincareroutineapi.enums.PigmentedSkin;
import com.example.mariabonitaskincareroutineapi.enums.SkinTypeClient;
import jakarta.validation.constraints.NotBlank;

public record UserRecordDto(@NotBlank String name, @NotBlank String email, @NotBlank String username,  @NotBlank String password, Age age, SkinTypeClient skinTypeClient,
                            HowMuch howMuch,
                            PigmentedSkin pigmentedSkin) {
}
