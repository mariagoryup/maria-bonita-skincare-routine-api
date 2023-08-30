package com.mariabonita.skincareroutine.controller;

import com.mariabonita.skincareroutine.domain.products.SkinType;
import com.mariabonita.skincareroutine.service.SkinTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("skinTypes")
public class SkinTypeController {
    private final SkinTypeService skinTypeService;

    @GetMapping
    public List<SkinType> getAllSkinType() {
        return skinTypeService.findAll();
    }

    @GetMapping("/{idSkinType}")
    public SkinType getSkinTypeById(@PathVariable Long idSkinType) {
        return skinTypeService.findById(idSkinType);
    }
}
