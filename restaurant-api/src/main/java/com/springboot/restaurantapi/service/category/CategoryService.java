package com.springboot.restaurantapi.service.category;

import com.springboot.restaurantapi.dto.CategoryDto;
import com.springboot.restaurantapi.mapper.CategoryMapper;
import com.springboot.restaurantapi.model.Category;
import com.springboot.restaurantapi.repository.CategoryRepository;
import jakarta.transaction.SystemException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService{

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryDto addCategory(CategoryDto categoryDto) throws SystemException {
        if (categoryDto.getId() != null) {
            throw new SystemException("error.id");
        }
        if (categoryDto.getName() == null || categoryDto.getName().isEmpty()) {
            throw new SystemException("error.name");
        }
        Category category = CategoryMapper.CATEGORY_MAPPER.toEntity(categoryDto);
        Category savedCategory = categoryRepository.save(category);
        return CategoryMapper.CATEGORY_MAPPER.toDto(savedCategory);
    }

    @Override
    public CategoryDto getCategoryByName(String name) {
        return categoryRepository.findByName(name)
                .map(CategoryMapper.CATEGORY_MAPPER::toDto)
                .orElseThrow(() -> new IllegalArgumentException("error.category.not.found.name"));
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .map(CategoryMapper.CATEGORY_MAPPER::toDto)
                .orElseThrow(() -> new IllegalArgumentException("error.category.not.found.id"));
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        if (categories.isEmpty()) {
            throw new IllegalArgumentException("error.category.not.found"); // Use a message key
        }
        return categories.stream()
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
            throw new IllegalArgumentException("error.category.not.found.id");
        }
        categoryRepository.deleteById(id);
    }
}
