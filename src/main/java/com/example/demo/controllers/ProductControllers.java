package com.example.demo.controllers;

import com.example.demo.domain.product.Products;
import com.example.demo.domain.product.ProductsRepository;
import com.example.demo.domain.product.RequestProduct;
import com.example.demo.domain.product.ResquestProductUpdate;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")


public class ProductControllers {

    @Autowired
    private ProductsRepository repository;


    @GetMapping
    public ResponseEntity getAllProducts(){
        //Method to get all the date in Products table.
        var allProducts = repository.findAll();
        return ResponseEntity.ok(allProducts);
    }

    @PostMapping
    public ResponseEntity addProduct(@RequestBody @Valid RequestProduct data){
        Products newProduct = new Products(data);
        System.out.println(data);
        repository.save(newProduct);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity updateProduct(@RequestBody @Valid ResquestProductUpdate dataUpdate){
        Products updateProduct = repository.getReferenceById(dataUpdate.id());

        updateProduct.setCategory(dataUpdate.category());
        updateProduct.setProduct_name(dataUpdate.product_name());
        updateProduct.setPrice(dataUpdate.price());
        updateProduct.setUnitsold(dataUpdate.unitsold());
        return ResponseEntity.ok(updateProduct);
    }



}
