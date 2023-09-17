package com.example.demo.domain.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestProduct(@NotBlank String category, @NotBlank String product_name, @NotNull float price, @NotNull Integer unitsold, @NotNull Integer quantity) {

}
