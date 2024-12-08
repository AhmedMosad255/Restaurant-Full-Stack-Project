package com.springboot.restaurantapi.repository;

import com.springboot.restaurantapi.model.Chef;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChefRepository extends JpaRepository<Chef, Long> {
}
