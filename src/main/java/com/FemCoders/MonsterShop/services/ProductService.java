package com.FemCoders.MonsterShop.services;

import com.FemCoders.MonsterShop.models.Product;
import com.FemCoders.MonsterShop.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product addProduct(Product newProduct){
        return productRepository.save(newProduct);
    }
}
