package com.example.demo.domain.product;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "products")
@Entity(name = "products")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Products {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String category;
    private String product_name;
    private float price;
    private int unitsold;
    private Boolean active;


    public Products(RequestProduct requestProduct){

        this.category = requestProduct.category();
        this.product_name = requestProduct.product_name();
        this.price = requestProduct.price();
        this.unitsold = requestProduct.unitsold();
        this.active = requestProduct.active();

    }



}
