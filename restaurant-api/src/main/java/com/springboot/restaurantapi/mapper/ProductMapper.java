package com.springboot.restaurantapi.mapper;

import com.springboot.restaurantapi.dto.ProductDto;
import com.springboot.restaurantapi.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {

    ProductMapper PRODUCT_MAPPER = Mappers.getMapper(ProductMapper.class);
    @Mapping(source = "category.id", target = "categoryId")
    ProductDto toDto(Product product);
    @Mapping(source = "categoryId", target = "category.id")
    Product toEntity(ProductDto productDto);

    List<ProductDto> toDtoList(List<Product> products);
    List<Product> toEntityList(List<ProductDto> productDtos);
}
