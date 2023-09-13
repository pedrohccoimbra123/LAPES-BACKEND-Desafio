package com.example.demo.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductsRepository extends JpaRepository<Products, Integer> {



    @Modifying
    @Query("DELETE FROM products p WHERE p.category = :category")
    int deleteByCategory(@Param("category") String category);

    @Query("SELECT p FROM products p ORDER BY p.unitsold DESC")
    List<Products> findByOrderByUnitsoldDesc();



}
