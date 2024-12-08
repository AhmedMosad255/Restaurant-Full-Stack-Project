package com.springboot.restaurantapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Chef {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String spec;
    private String logoPath;
    private String faceLink;
    private String tweLink;
    private String instaLink;
}