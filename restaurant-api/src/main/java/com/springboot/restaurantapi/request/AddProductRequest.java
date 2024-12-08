package com.springboot.restaurantapi.request;

import com.springboot.restaurantapi.model.Category;
import lombok.Data;

@Data
public class AddProductRequest {
    private Long id;
    private String name;
    private String logoPath;
    private String description;
    private double price;
    private Category category;
}
