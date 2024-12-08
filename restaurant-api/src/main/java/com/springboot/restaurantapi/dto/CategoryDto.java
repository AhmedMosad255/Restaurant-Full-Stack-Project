package com.springboot.restaurantapi.dto;

import lombok.Data;

@Data
public class CategoryDto {
    private Long id;
    private String name;
    private String logoPath;
    private String flag;
}
