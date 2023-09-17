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

    //Get all products
    @GetMapping(value = "allProducts")
    public ResponseEntity getAllProducts(){
        //Method to get all the date in Products table.
        var allProducts = repository.findAll();
        return ResponseEntity.ok(allProducts);
    }
    //Get Products by price range
    @GetMapping("/products/pricerange/{minPrice}/{maxPrice}")
    public ResponseEntity<List<Products>> getProductsByPriceRange(
            @PathVariable Float minPrice,
            @PathVariable Float maxPrice) {

        List<Products> products = repository.findByPriceRange(minPrice, maxPrice);

        if (!products.isEmpty()) {
            return ResponseEntity.ok(products);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/products/byname/{productName}")
    public ResponseEntity<List<Products>> findProductByName(@PathVariable String productName){
        List<Products> products = repository.findProductByName(productName);
        if (!products.isEmpty()) {
            return ResponseEntity.ok(products);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    //Add products
    @PostMapping(value = "addProduct")
    public ResponseEntity<String> addProduct(@RequestBody @Valid RequestProduct data) {

        Products newProduct = new Products(data);


        repository.save(newProduct);

        String message = "Produto adicionado com sucesso!!!";
        return ResponseEntity.ok(message);
    }

    //update products
    @PutMapping(value = "updateProduct")
    @Transactional
    public ResponseEntity updateProduct(@RequestBody @Valid ResquestProductUpdate data){
        Optional<Products> optionalProduct = repository.findById(data.id());
        if (optionalProduct.isPresent()) {
            Products product = optionalProduct.get();
            product.setCategory(data.category());
            product.setProduct_name(data.product_name());
            product.setPrice(data.price());
            product.setUnitsold(data.unitsold());
            product.setQuantity(data.quantity());

            return ResponseEntity.ok(product);
        } else {
             throw new EntityNotFoundException();
        }
    }


    //Endpoints to delete products by id
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


    //End point to Delete products by category
    @DeleteMapping(value = "/category/{category}")
    @Transactional
    public ResponseEntity<String> deleteProduct(@PathVariable String category) {
        int deletedCount = repository.deleteByCategory(category);

        if (deletedCount > 0) {
            return ResponseEntity.ok("All the products in the " + category + " were successfully deleted");
        } else {
            throw new EntityNotFoundException("There is no product in this " + category);
        }
    }
    //Endpoint to get products sorted by unitsolds
    @GetMapping("/unitsold/most")
    public ResponseEntity<List<Products>> getProductsSortedByUnitsold() {
        List<Products> sortedProducts = repository.findByOrderByUnitsoldDesc();

        if (sortedProducts.isEmpty()) {
            throw new EntityNotFoundException("Nenhum produto vendido encontrado");
        } else {
            return ResponseEntity.ok(sortedProducts);
        }
    }

    //Getting the least sold products
    @GetMapping("/unitsold/least")
    public ResponseEntity<List<Products>> getProductsSortedByUnitsoldAsc() {
        List<Products> sortedProducts = repository.findByOrderByUnitsoldAsc();

        if (sortedProducts.isEmpty()) {
            throw new EntityNotFoundException("Nenhum produto vendido encontrado");
        } else {
            return ResponseEntity.ok(sortedProducts);
        }
    }

}







