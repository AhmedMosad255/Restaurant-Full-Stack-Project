package com.springboot.restaurantapi.service.product;


import com.springboot.restaurantapi.dto.ProductDto;

import java.util.List;

public interface IProductService {
//    ProductDto addProduct(ProductDto productDto);

    ProductDto getProductById(Long id);

    ProductDto updateProduct(ProductDto productDto, Long productId);

    List<ProductDto> getAllProducts();

    List<ProductDto> getProductsByCategoryId(Long categoryId);

    List<ProductDto> getProductByName(String productName);

    List<ProductDto> getProductByLetters(String letter);

}
