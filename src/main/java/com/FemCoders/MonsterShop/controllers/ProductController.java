package com.FemCoders.MonsterShop.controllers;

import com.FemCoders.MonsterShop.models.Product;
import com.FemCoders.MonsterShop.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }

    @PostMapping("/{Id}")
    public ResponseEntity<Product> addProduct(@RequestBody Product newProduct){
        Product createdProduct = productService.addProduct(newProduct);
        return new ResponseEntity<Product>(createdProduct, HttpStatus.CREATED);
    }
}
