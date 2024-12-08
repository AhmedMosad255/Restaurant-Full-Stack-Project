package com.springboot.restaurantapi.service.chef;


import com.springboot.restaurantapi.dto.ChefDto;

import java.util.List;
import java.util.Optional;

public interface IChefService {
    ChefDto createChef(ChefDto chefDto);
    Optional<ChefDto> getChefById(Long id);
    List<ChefDto> getAllChefs();
}
