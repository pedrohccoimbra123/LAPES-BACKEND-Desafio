package com.example.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")


public class ProductControllers {

    @GetMapping
    public ResponseEntity getAllProducts(){
        return ResponseEntity.ok("ta ok seu corno");
    }

}
