package com.springboot.restaurantapi.controller;

import com.springboot.restaurantapi.dto.CategoryDto;
import com.springboot.restaurantapi.service.category.ICategoryService;
import jakarta.transaction.SystemException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("${api.prefix}/category")
@RequiredArgsConstructor
//@CrossOrigin("http://localhost:4200")
public class CategoryController {

    private final ICategoryService categoryService;

    @PostMapping("/add")
    public ResponseEntity<CategoryDto> addCategory(@RequestBody CategoryDto categoryDto) throws SystemException {
        return ResponseEntity.status(CREATED).body(categoryService.addCategory(categoryDto));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Long id){
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CategoryDto>> getAllCategories(){
        return ResponseEntity.ok(categoryService.getAllCategories());
    }
    @GetMapping("/name")
    public ResponseEntity<CategoryDto> getCategoryByName(@RequestParam String name){
        return ResponseEntity.ok(categoryService.getCategoryByName(name));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CategoryDto> updateCategory(
            @RequestBody CategoryDto categoryDto,
            @PathVariable Long id
    ){
        return ResponseEntity.ok(categoryService.updateCategory(categoryDto, id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoryById(@PathVariable Long id) {
        categoryService.deleteCategoryById(id);
        return ResponseEntity.noContent().build();
    }
}
