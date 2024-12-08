package com.springboot.restaurantapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class ChefDto {

    private Long id;

    @NotBlank(message = "Name is required and cannot be empty")
    @Size(max = 50, message = "Name cannot exceed 50 characters")
    private String name;

    @NotBlank(message = "Specialization is required and cannot be empty")
    @Size(max = 100, message = "Specialization cannot exceed 100 characters")
    private String spec;

    @NotBlank(message = "Logo path is required and cannot be empty")
    private String logoPath;

    @Pattern(regexp = "^(http|https)://.*$", message = "Facebook link must be a valid URL")
    private String facebookLink;

    @Pattern(regexp = "^(http|https)://.*$", message = "Twitter link must be a valid URL")
    private String tweeterLink;

    @Pattern(regexp = "^(http|https)://.*$", message = "Instagram link must be a valid URL")
    private String instagramLink;
}
