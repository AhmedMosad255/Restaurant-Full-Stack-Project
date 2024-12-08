package com.springboot.restaurantapi.controller;

import com.springboot.restaurantapi.dto.ProductDto;
import com.springboot.restaurantapi.service.product.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("${api.prefix}/product")
@RequiredArgsConstructor
public class ProductController {
    private final IProductService productService;

    @PostMapping("/add")
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto){
        return ResponseEntity.status(CREATED).body(productService.addProduct(productDto));
    }
    @GetMapping("/get/{productId}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long productId){
        return ResponseEntity.ok(productService.getProductById(productId));
    }
    @PutMapping("/update/{productId}")
    public ResponseEntity<ProductDto> updateProduct(
            @RequestBody ProductDto productDto,
            @PathVariable Long productId
    ){
        return ResponseEntity.ok(productService.updateProduct(productDto, productId));
    }
}
