package com.springboot.restaurantapi.service.category;


import com.springboot.restaurantapi.dto.CategoryDto;

import java.util.List;

public interface ICategoryService {
    CategoryDto addCategory(CategoryDto categoryDto);
    CategoryDto getCategoryByName(String name);
    CategoryDto getCategoryById(Long id);
    List<CategoryDto> getAllCategories();
    CategoryDto updateCategory(CategoryDto category, Long id);
    void deleteCategoryById(Long id);
}
