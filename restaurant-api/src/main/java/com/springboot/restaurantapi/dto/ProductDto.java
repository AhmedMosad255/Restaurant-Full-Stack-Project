package com.springboot.restaurantapi.dto;

import lombok.Data;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private String logoPath;
    private String description;
    private double price;
    private Long categoryId;
}
