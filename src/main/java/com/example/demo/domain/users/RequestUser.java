package com.example.demo.domain.users;

import jakarta.validation.constraints.NotBlank;

public record RequestUser(@NotBlank String email) {


}
