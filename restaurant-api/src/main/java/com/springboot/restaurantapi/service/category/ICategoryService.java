package com.springboot.restaurantapi.service.category;


import com.springboot.restaurantapi.dto.CategoryDto;
import jakarta.transaction.SystemException;

import java.util.List;

public interface ICategoryService {
    CategoryDto addCategory(CategoryDto categoryDto) throws SystemException;
    CategoryDto getCategoryByName(String name);
    CategoryDto getCategoryById(Long id);
    List<CategoryDto> getAllCategories();
    CategoryDto updateCategory(CategoryDto category, Long id);
    void deleteCategoryById(Long id);
}
