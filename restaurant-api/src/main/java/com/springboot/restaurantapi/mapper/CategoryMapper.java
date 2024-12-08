package com.springboot.restaurantapi.mapper;

import com.springboot.restaurantapi.dto.CategoryDto;
import com.springboot.restaurantapi.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryMapper {

    CategoryMapper CATEGORY_MAPPER = Mappers.getMapper(CategoryMapper.class);

    CategoryDto toDto(Category category);
    Category toEntity(CategoryDto categoryDto);

    List<CategoryDto> toDtoList(List<Category> categories);
    List<Category> toEntityList(List<CategoryDto> categoryDtos);
}
