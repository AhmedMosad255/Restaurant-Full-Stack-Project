package com.springboot.restaurantapi.service.product;

import com.springboot.restaurantapi.dto.ProductDto;
import com.springboot.restaurantapi.mapper.ProductMapper;
import com.springboot.restaurantapi.model.Category;
import com.springboot.restaurantapi.model.Product;
import com.springboot.restaurantapi.repository.CategoryRepository;
import com.springboot.restaurantapi.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;


    @Override
    public ProductDto addProduct(ProductDto productDto) {
        // Retrieve the category from the database using categoryId
        Category category = categoryRepository.findById(productDto.getCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("Category not found with id: " + productDto.getCategoryId()));
        // Convert ProductDto to Product entity and set the category
        Product product = ProductMapper.PRODUCT_MAPPER.toEntity(productDto);
        product.setCategory(category);
        // Save the product to the database
        Product savedProduct = productRepository.save(product);
        // Convert the saved product entity back to ProductDto
        ProductDto savedProductDto = ProductMapper.PRODUCT_MAPPER.toDto(savedProduct);
        // Set categoryId in the saved ProductDto
        savedProductDto.setCategoryId(savedProduct.getCategory().getId());
        return savedProductDto;
    }

    @Override
    public ProductDto getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found with id: " + id));
        return ProductMapper.PRODUCT_MAPPER.toDto(product);
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto, Long productId) {
        Product existingProduct = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found with id: " + productId));

        // Update product details
        existingProduct.setName(productDto.getName());
        existingProduct.setLogoPath(productDto.getLogoPath());
        existingProduct.setDescription(productDto.getDescription());
        existingProduct.setPrice(productDto.getPrice());

        // Save and return the updated product
        Product updatedProduct = productRepository.save(existingProduct);
        return ProductMapper.PRODUCT_MAPPER.toDto(updatedProduct);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream()
                .map(ProductMapper.PRODUCT_MAPPER::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> getProductsByCategoryId(Long categoryId) {
        return productRepository.findByCategoryId(categoryId).stream()
                .map(ProductMapper.PRODUCT_MAPPER::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> searchProducts(String key) {
        return productRepository.findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(key, key).stream()
                .map(ProductMapper.PRODUCT_MAPPER::toDto)
                .collect(Collectors.toList());
    }
}
