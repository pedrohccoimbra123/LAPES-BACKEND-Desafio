package com.example.demo.domain.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

public record ResquestProductUpdate(Integer id,String category, String product_name, float price, Integer unitsold){
}
