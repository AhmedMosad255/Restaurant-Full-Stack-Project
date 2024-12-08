package com.springboot.restaurantapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Category {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String logoPath;
    private String flag;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
