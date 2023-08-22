package com.example.mariabonitaskincareroutineapi.controller;

import com.example.mariabonitaskincareroutineapi.domain.products.Category;
import com.example.mariabonitaskincareroutineapi.domain.products.SkinType;
import com.example.mariabonitaskincareroutineapi.repository.SkinTypeRepository;
import com.example.mariabonitaskincareroutineapi.service.SkinTypeService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("skinType")
public class SkinTypeController
{
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
