package com.springboot.restaurantapi.controller;

import com.springboot.restaurantapi.dto.ChefDto;
import com.springboot.restaurantapi.service.chef.IChefService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("${api.prefix}/chef")
@RequiredArgsConstructor
public class ChefController {
    private final IChefService chefService;

    @PostMapping("/add")
    public ResponseEntity<ChefDto> createChef(@Valid @RequestBody ChefDto chefDto){
        return ResponseEntity.status(CREATED).body(chefService.createChef(chefDto));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ChefDto> getChefById(@PathVariable Long id){
        return ResponseEntity.of(chefService.getChefById(id));
    }
    @GetMapping("/all")
    public ResponseEntity<List<ChefDto>> getAllChefs() {
        return ResponseEntity.ok(chefService.getAllChefs());
    }
}
