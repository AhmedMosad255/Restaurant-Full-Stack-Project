package com.springboot.restaurantapi.service.chef;

import com.springboot.restaurantapi.dto.ChefDto;
import com.springboot.restaurantapi.mapper.ChefMapper;
import com.springboot.restaurantapi.model.Chef;
import com.springboot.restaurantapi.repository.ChefRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChefService implements IChefService {
    private final ChefRepository chefRepository;

    @Override
    public ChefDto createChef(ChefDto chefDto) {
        Chef chef = ChefMapper.CHEF_MAPPER.toEntity(chefDto); // Convert DTO to Entity
        Chef savedChef = chefRepository.save(chef);          // Save Entity
        return ChefMapper.CHEF_MAPPER.toDto(savedChef);      // Convert Entity back to DTO
    }

    @Override
    public Optional<ChefDto> getChefById(Long id) {
        return Optional.of(chefRepository.findById(id)
                .map(ChefMapper.CHEF_MAPPER::toDto)
                .orElseThrow(() -> new IllegalArgumentException("error.chef.not.found.id")));
    }

    @Override
    public List<ChefDto> getAllChefs() {
        List<Chef> chefs = chefRepository.findAll(); // Fetch all Chef Entities
        if (chefs.isEmpty()) {
            throw new IllegalArgumentException("error.chef.not.found"); // Pass the key to the exception
        }
        return ChefMapper.CHEF_MAPPER.toDtoList(chefs); // Convert List of Entities to List of DTOs
    }
}
