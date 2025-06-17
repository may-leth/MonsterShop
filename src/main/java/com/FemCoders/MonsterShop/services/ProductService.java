package com.FemCoders.MonsterShop.services;

import com.FemCoders.MonsterShop.models.Product;
import com.FemCoders.MonsterShop.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Product> getProduct(Long id){
        return productRepository.findById(id);
    }

    public void deleteProduct(long id){
        productRepository.deleteById(id);
    }

}
