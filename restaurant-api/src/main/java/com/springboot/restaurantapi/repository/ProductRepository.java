package com.springboot.restaurantapi.repository;

import com.springboot.restaurantapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByCategoryId(Long id);
    List<Product> findByName(String name);

    @Query(value = "SELECT * FROM Product WHERE name LIKE %:val% OR DESCRIPTION LIKE %:val%", nativeQuery = true)
    List<Product> getProductByLetters(@Param("val") String letters);
}
