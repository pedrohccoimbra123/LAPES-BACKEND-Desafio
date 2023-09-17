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

    @Query("SELECT s FROM products s WHERE s.price >= :minPrice AND s.price <= :maxPrice ORDER BY s.price DESC")
    List<Products> findByPriceRange(@Param("minPrice") Float minPrice, @Param("maxPrice") Float maxPrice);

    @Query("SELECT p FROM products p WHERE p.product_name =:productName")
    List<Products> findProductByName(@Param("productName") String productName);
    @Query("SELECT p FROM products  p ORDER BY p.unitsold ASC")
    List<Products> findByOrderByUnitsoldAsc();

}
