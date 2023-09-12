package com.example.demo.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Products, Integer> {

    List<Products> findAllByActiveTrue();

}
