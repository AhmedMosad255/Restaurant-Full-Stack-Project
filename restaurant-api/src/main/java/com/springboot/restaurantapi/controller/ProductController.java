package com.springboot.restaurantapi.controller;

import com.springboot.restaurantapi.dto.ProductDto;
import com.springboot.restaurantapi.service.product.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("${api.prefix}/product")
@RequiredArgsConstructor
public class ProductController {
    private final IProductService productService;

//    @PostMapping("/add")
//    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto){
//        return ResponseEntity.status(CREATED).body(productService.addProduct(productDto));
//    }
    @GetMapping("/get/{productId}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long productId){
        return ResponseEntity.ok(productService.getProductById(productId));
    }
    @GetMapping("/getProductsBy/{id}")
    ResponseEntity<List<ProductDto>> productByCategoryId(@PathVariable("id") Long CategoryId) {
        return ResponseEntity.ok(productService.getProductsByCategoryId(CategoryId));
    }
    @PutMapping("/update/{productId}")
    public ResponseEntity<ProductDto> updateProduct(
            @RequestBody ProductDto productDto,
            @PathVariable Long productId
    ){
        return ResponseEntity.ok(productService.updateProduct(productDto, productId));
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }
    @GetMapping("/byName/{name}")
    public ResponseEntity<List<ProductDto>> getProductsByName(@PathVariable String name){
        return ResponseEntity.ok(productService.getProductByName(name));
    }

    @GetMapping("/byLetters/{letter}")
    public ResponseEntity<List<ProductDto>> getProductByLetters(@PathVariable String letter) {
        return ResponseEntity.ok(productService.getProductByLetters(letter));
    }
}
