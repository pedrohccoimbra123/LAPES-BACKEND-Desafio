package com.example.demo.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductsRepository extends JpaRepository<Products, Integer> {

    List<Products> findAllByActiveTrue();

    Optional<Products> findByCategory(@Param("category") String category);

}
