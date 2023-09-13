package com.example.demo.controllers;


import com.example.demo.domain.product.Products;
import com.example.demo.domain.product.ProductsRepository;
import com.example.demo.domain.product.RequestProduct;
import com.example.demo.domain.product.ResquestProductUpdate;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<String> addProduct(@RequestBody @Valid RequestProduct data){
        Products newProduct = new Products(data);
        String message = "Produto adicionado com sucesso";
        return ResponseEntity.ok(message);
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
             throw new EntityNotFoundException();
        }
    }

    @DeleteMapping(value = "/{id}")
    @Transactional
    public ResponseEntity deleteProduct(@PathVariable Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.ok("Produto com o ID " + id + " foi excluído com sucesso.");
        } else {
            throw new EntityNotFoundException("Produto com o ID " + id + " não encontrado");
        }
    }


    //Delete by category
    @DeleteMapping(value = "/category/{category}")
    @Transactional
    public ResponseEntity<String> deleteProduct(@PathVariable String category) {
        int deletedCount = repository.deleteByCategory(category);

        if (deletedCount > 0) {
            return ResponseEntity.ok("Produtos na categoria " + category + " foram excluídos com sucesso.");
        } else {
            throw new EntityNotFoundException("Nenhum produto encontrado na categoria " + category);
        }
    }
    @GetMapping("/unitsold/sorted")
    public ResponseEntity<List<Products>> getProductsSortedByUnitsold() {
        List<Products> sortedProducts = repository.findByOrderByUnitsoldDesc();

        if (sortedProducts.isEmpty()) {
            throw new EntityNotFoundException("Nenhum produto vendido encontrado");
        } else {
            return ResponseEntity.ok(sortedProducts);
        }
    }

}







