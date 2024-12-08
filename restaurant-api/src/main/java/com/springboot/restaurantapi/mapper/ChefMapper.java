package com.springboot.restaurantapi.mapper;

import com.springboot.restaurantapi.dto.ChefDto;
import com.springboot.restaurantapi.model.Chef;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ChefMapper {
    ChefMapper CHEF_MAPPER = Mappers.getMapper(ChefMapper.class);

    @Mapping(source = "faceLink", target = "facebookLink")
    @Mapping(source = "tweLink", target = "tweeterLink")
    @Mapping(source = "instaLink", target = "instagramLink")
    ChefDto toDto(Chef chef); // Maps Chef entity to ChefDto

    @Mapping(source = "facebookLink", target = "faceLink")
    @Mapping(source = "tweeterLink", target = "tweLink")
    @Mapping(source = "instagramLink", target = "instaLink")
    Chef toEntity(ChefDto chefDto); // Maps ChefDto to Chef entity

    List<ChefDto> toDtoList(List<Chef> chefs);

    List<Chef> toEntityList(List<ChefDto> chefDtos);
}
