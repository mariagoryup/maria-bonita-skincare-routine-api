package com.mariabonita.skincareroutine.dtos;

import com.mariabonita.skincareroutine.enums.Age;
import com.mariabonita.skincareroutine.enums.HowMuch;
import com.mariabonita.skincareroutine.enums.PigmentedSkin;
import com.mariabonita.skincareroutine.enums.SkinTypeClient;
import jakarta.validation.constraints.NotBlank;

public record ClientRecordDto(@NotBlank String name, @NotBlank String email, Age age, SkinTypeClient skinTypeClient,
                              HowMuch howMuch,
                              PigmentedSkin pigmentedSkin) {
}
