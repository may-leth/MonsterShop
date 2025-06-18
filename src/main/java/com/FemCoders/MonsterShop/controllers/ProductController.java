package com.FemCoders.MonsterShop.controllers;

import com.FemCoders.MonsterShop.dtos.Product.ProductRequest;
import com.FemCoders.MonsterShop.dtos.Product.ProductResponse;
import com.FemCoders.MonsterShop.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts(){
        List<ProductResponse> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @PostMapping
    public ResponseEntity<ProductResponse> addProduct(@RequestBody @Valid ProductRequest newProduct){
        ProductResponse createdProduct = productService.addProduct(newProduct);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable Long id){
        return productService.getProduct(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable Long id, @RequestBody @Valid ProductRequest updatedProduct){
        try {
            ProductResponse response = productService.updateProduct(id, updatedProduct);
            return ResponseEntity.ok(response);
        } catch (NoSuchElementException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable long id){
        if (productService.deleteProduct(id)){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
