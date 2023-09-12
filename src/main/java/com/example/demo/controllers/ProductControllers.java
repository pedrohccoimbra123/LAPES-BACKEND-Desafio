package com.example.demo.controllers;

import com.example.demo.domain.product.Products;
import com.example.demo.domain.product.ProductsRepository;
import com.example.demo.domain.product.RequestProduct;
import com.example.demo.domain.product.ResquestProductUpdate;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/product")

public class ProductControllers {

    @Autowired
    private ProductsRepository repository;


    @GetMapping
    public ResponseEntity getAllProducts(){
        //Method to get all the date in Products table.
        var allProducts = repository.findAllByActiveTrue();
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
    @Transactional
    public ResponseEntity updateProduct(@RequestBody @Valid ResquestProductUpdate data){
        Optional<Products> optionalProduct = repository.findById(data.id());
        if (optionalProduct.isPresent()) {
            Products product = optionalProduct.get();
            product.setCategory(data.category());
            product.setProduct_name(data.product_name());
            product.setPrice(data.price());
            product.setUnitsold(data.unitsold());
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteProduct(@PathVariable Integer id) {
        Optional<Products> optionalProducts = repository.findById(id);
        if (optionalProducts.isPresent()){
            Products products = optionalProducts.get();
            products.setActive(false);
            return ResponseEntity.ok(products);
        }


        return ResponseEntity.noContent().build();
    }




}
