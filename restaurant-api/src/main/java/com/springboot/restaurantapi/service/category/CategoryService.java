package com.springboot.restaurantapi.service.category;

import com.springboot.restaurantapi.dto.CategoryDto;
import com.springboot.restaurantapi.mapper.CategoryMapper;
import com.springboot.restaurantapi.model.Category;
import com.springboot.restaurantapi.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService{

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryDto addCategory(CategoryDto categoryDto) {
        Category category = CategoryMapper.CATEGORY_MAPPER.toEntity(categoryDto);
        Category savedCategory = categoryRepository.save(category);
        return CategoryMapper.CATEGORY_MAPPER.toDto(savedCategory);
    }

    @Override
    public CategoryDto getCategoryByName(String name) {
        return categoryRepository.findByName(name)
                .map(CategoryMapper.CATEGORY_MAPPER::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Category not found with name : " + name));
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .map(CategoryMapper.CATEGORY_MAPPER::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Category not found with id: " + id));
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        return categoryRepository
                .findAll()
                .stream()
                .map(CategoryMapper.CATEGORY_MAPPER::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Long id) {
        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Category not found with id: " + id));
        existingCategory.setName(categoryDto.getName());
        existingCategory.setLogoPath(categoryDto.getLogoPath());
        existingCategory.setFlag(categoryDto.getFlag());

        Category updatedCategory = categoryRepository.save(existingCategory);
        return CategoryMapper.CATEGORY_MAPPER.toDto(updatedCategory);
    }

    @Override
    public void deleteCategoryById(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new IllegalArgumentException("Category not found with id: " + id);
        }
        categoryRepository.deleteById(id);
    }
}
